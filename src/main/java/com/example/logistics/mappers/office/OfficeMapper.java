package com.example.logistics.mappers.office;

import com.example.logistics.api.dto.office.OfficeRequestDto;
import com.example.logistics.api.dto.office.OfficeResponseDto;
import com.example.logistics.model.Office;

public interface OfficeMapper {
    Office mapDtoToEntity(OfficeRequestDto dto);

    Office updateEntityFromDto(OfficeRequestDto dto, Office office);

    OfficeResponseDto mapEntityToDto(Office office);
}
