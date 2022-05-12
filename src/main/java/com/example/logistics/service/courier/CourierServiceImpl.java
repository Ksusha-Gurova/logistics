package com.example.logistics.service.courier;

import com.example.logistics.api.dto.request.CourierRequestDto;
import com.example.logistics.api.dto.response.CourierResponseDto;
import com.example.logistics.model.Courier;
import com.example.logistics.mappers.CourierMapper;
import com.example.logistics.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper mapper;

    @Override
    public List<CourierResponseDto> findAll() {
        log.info("findAll()");
        return courierRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public CourierResponseDto findCourier(Long id) {
        log.info("findCourier(), id = {}", id);
        Optional<Courier> optionalCourier = courierRepository.findById(id);
        return optionalCourier.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public CourierResponseDto saveOrUpdateCourier(CourierRequestDto dto) {
        log.info("saveOrUpdateCourier(), dto = {}", dto);
        try {
            Courier updatedOrNewCourier = Optional.ofNullable(dto.getId())
                    .map(courierId -> courierRepository.findById(courierId)
                            .map(courier -> mapper.updateEntityFromDto(dto, courier))
                            .orElseThrow(() -> new EntityNotFoundException("Не существует в базе курьера с id = " + dto.getId())))
                    .orElse(mapper.mapDtoToEntity(dto));
            updatedOrNewCourier = courierRepository.save(updatedOrNewCourier);
            log.info("saveOrUpdateCourier(), сохранены данные в базу, updatedOrNewCourier = {}", updatedOrNewCourier);
            return mapper.mapEntityToDto(updatedOrNewCourier);
        } catch (DataAccessException e){
            log.info("saveOrUpdateCourier(), ошибка сохранения в базу");
            throw new PersistenceException("В ходе обработки запроса произошла ошибка: "+ e.getMessage());
        }

    }


    @Override
    public void deleteCourier(Long id) {
        log.info("deleteCourier(), id = {}", id);
        courierRepository.deleteById(id);
    }
}
