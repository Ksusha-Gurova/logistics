package com.example.logistics.mappers.office;

import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;
import com.example.logistics.model.Office;

public interface OfficeMapper {
    Office mapDtoToEntity(OfficeRequestDto dto);

    Office updateEntityFromDto(OfficeRequestDto dto, Office office);

    OfficeResponseDto mapEntityToDto(Office office);
}
