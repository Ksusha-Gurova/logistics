package com.example.logistics.service.office;

import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;
import com.example.logistics.model.City;
import com.example.logistics.model.Office;
import com.example.logistics.mappers.office.OfficeMapper;
import com.example.logistics.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;
    private  final OfficeMapper mapper;

    @Override
    public List<OfficeResponseDto> findAll() {
        return officeRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public OfficeResponseDto findOffice(Long id) {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        return optionalOffice.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public OfficeResponseDto saveOrUpdateOffice(OfficeRequestDto dto) {
        Office updatedOrSaveOffice = Optional.ofNullable(dto.getId())
                .map(officeId -> officeRepository.findById(officeId)
                        .map(client -> mapper.updateEntityFromDto(dto, client))
                        .orElseThrow(() -> new EntityNotFoundException("Не существует в базе клиента с id = " + dto.getId())))
                .orElse(mapper.mapDtoToEntity(dto));
        updatedOrSaveOffice = officeRepository.save(updatedOrSaveOffice);

        return mapper.mapEntityToDto(updatedOrSaveOffice);
    }

    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }

    @Override
    public List<OfficeResponseDto> findOfficesByCity(String city) {
        return officeRepository.findAllByCity(City.valueOf(city)).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }
}
