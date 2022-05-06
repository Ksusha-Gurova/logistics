package com.example.logistics.service.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.dto.office.OfficeResponseDto;
import com.example.logistics.model.Office;

import java.util.List;

public interface OfficeService {
    List<OfficeResponseDto> findAll();

    OfficeResponseDto findOffice(Long id);

    OfficeResponseDto updateOffice(OfficeRequestDto dto);

    OfficeResponseDto saveNewOffice(OfficeRequestDto dto);

    void deleteOffice(Long id);
}
