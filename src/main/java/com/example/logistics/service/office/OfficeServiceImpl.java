package com.example.logistics.service.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.model.Office;
import com.example.logistics.mappers.office.OfficeMapper;
import com.example.logistics.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;
    private  final OfficeMapper mapper;

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office findOffice(Long id) {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        return optionalOffice.orElse(null);
    }

    @Override
    public Office updateOffice(OfficeRequestDto dto) {
        Office office = officeRepository.findById(dto.getId()).orElse(null);
        if (office != null){
            return officeRepository.save(mapper.updateEntityFromDto(dto, office));
        } else return saveNewOffice(dto);
    }

    @Override
    public Office saveNewOffice(OfficeRequestDto dto) {
        return officeRepository.save(mapper.mapDtoToEntity(dto));
    }

    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}
