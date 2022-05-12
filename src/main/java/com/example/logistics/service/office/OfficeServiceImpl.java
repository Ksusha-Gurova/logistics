package com.example.logistics.service.office;

import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;
import com.example.logistics.model.City;
import com.example.logistics.model.Office;
import com.example.logistics.mappers.OfficeMapper;
import com.example.logistics.repository.OfficeRepository;
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
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;
    private  final OfficeMapper mapper;

    @Override
    public List<OfficeResponseDto> findAll() {
        log.info("findAll()");
        return officeRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public OfficeResponseDto findOffice(Long id) {
        log.info("findOffice(), id = {}", id);
        Optional<Office> optionalOffice = officeRepository.findById(id);
        return optionalOffice.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public OfficeResponseDto saveOrUpdateOffice(OfficeRequestDto dto) {
        log.info("saveOrUpdateOffice(), dto = {}", dto);
        try {
            Office updatedOrNewOffice = Optional.ofNullable(dto.getId())
                    .map(officeId -> officeRepository.findById(officeId)
                            .map(client -> mapper.updateEntityFromDto(dto, client))
                            .orElseThrow(() -> new EntityNotFoundException("Не существует в базе клиента с id = " + dto.getId())))
                    .orElse(mapper.mapDtoToEntity(dto));
            updatedOrNewOffice = officeRepository.save(updatedOrNewOffice);
            log.info("saveOrUpdateOffice(), сохранены данные в базу, updatedOrNewOffice = {}", updatedOrNewOffice);
            return mapper.mapEntityToDto(updatedOrNewOffice);
        } catch (DataAccessException e){
            log.info("saveOrUpdateOffice(), ошибка сохранения в базу");
            throw new PersistenceException("В ходе обработки запроса произошла ошибка: " + e.getMessage());
        }

    }

    @Override
    public void deleteOffice(Long id) {
        log.info("deleteOffice(), id = {}", id);
        officeRepository.deleteById(id);
    }

    @Override
    public List<OfficeResponseDto> findOfficesByCity(String city) {
        log.info("findOfficesByCity(), city = {}", city);
        return officeRepository.findAllByCity(City.valueOf(city)).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }
}
