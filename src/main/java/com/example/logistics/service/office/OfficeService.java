package com.example.logistics.service.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.entity.Office;

import java.util.List;

public interface OfficeService {
    List<Office> findAll();

    Office findOffice(Long id);

    Office updateOffice(OfficeRequestDto dto);

    Office saveNewOffice(OfficeRequestDto dto);

    void deleteOffice(Long id);
}
