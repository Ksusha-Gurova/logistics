package com.example.logistics.service.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.entity.Office;
import com.example.logistics.mappers.office.OfficeMapper;
import com.example.logistics.repository.OfficeRepository;
import com.example.logistics.service.office.OfficeService;
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
        List<Office> allOffices = officeRepository.findAll();
        return allOffices;
    }

    @Override
    public Office findOffice(Long id) {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        return optionalOffice.get();
    }

    @Override
    public Office updateOffice(OfficeRequestDto dto) {
        Office office = officeRepository.getById(dto.getId());
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
