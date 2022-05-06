package com.example.logistics.service.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.dto.office.OfficeResponseDto;
import com.example.logistics.model.Office;
import com.example.logistics.mappers.office.OfficeMapper;
import com.example.logistics.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public OfficeResponseDto updateOffice(OfficeRequestDto dto) {
        Office office = officeRepository.findById(dto.getId()).orElse(null);
        if (office != null){
            Office updatedOffice = officeRepository.save(mapper.updateEntityFromDto(dto, office));
            return mapper.mapEntityToDto(updatedOffice);
        } else return saveNewOffice(dto);
    }

    @Override
    public OfficeResponseDto saveNewOffice(OfficeRequestDto dto) {
        Office newOffice = officeRepository.save(mapper.mapDtoToEntity(dto));
        return mapper.mapEntityToDto(newOffice);
    }

    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}
