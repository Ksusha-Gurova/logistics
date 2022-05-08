package com.example.logistics.service.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.dto.office.OfficeResponseDto;

import java.util.List;

public interface OfficeService {
    List<OfficeResponseDto> findAll();

    OfficeResponseDto findOffice(Long id);

    OfficeResponseDto saveOrUpdateOffice(OfficeRequestDto dto);

    void deleteOffice(Long id);
}
