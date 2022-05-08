package com.example.logistics.service.courier;

import com.example.logistics.api.dto.courier.CourierRequestDto;
import com.example.logistics.api.dto.courier.CourierResponseDto;
import com.example.logistics.model.Courier;
import com.example.logistics.mappers.courier.CourierMapper;
import com.example.logistics.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper mapper;

    @Override
    public List<CourierResponseDto> findAll() {
        return courierRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public CourierResponseDto findCourier(Long id) {
        Optional<Courier> optionalCourier = courierRepository.findById(id);
        return optionalCourier.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public CourierResponseDto saveOrUpdateCourier(CourierRequestDto dto) {
        Courier updetedOrNewCourier = Optional.ofNullable(dto.getId())
                .map(courierId -> courierRepository.findById(courierId)
                        .map(courier -> mapper.updateEntityFromDto(dto, courier))
                        .orElseThrow(() -> new EntityNotFoundException("Не существует в базе курьера с id = " + dto.getId())))
                .orElse(mapper.mapDtoToEntity(dto));
        updetedOrNewCourier = courierRepository.save(updetedOrNewCourier);

        return mapper.mapEntityToDto(updetedOrNewCourier);
    }


    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
