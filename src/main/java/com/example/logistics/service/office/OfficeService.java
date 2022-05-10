package com.example.logistics.service.office;

import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;

import java.util.List;

public interface OfficeService {
    List<OfficeResponseDto> findAll();

    OfficeResponseDto findOffice(Long id);

    OfficeResponseDto saveOrUpdateOffice(OfficeRequestDto dto);

    void deleteOffice(Long id);

    List<OfficeResponseDto> findOfficesByCity(String city);
}
