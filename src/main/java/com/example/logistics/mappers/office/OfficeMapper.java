package com.example.logistics.mappers.office;

import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.entity.Office;

public interface OfficeMapper {
    Office mapDtoToEntity(OfficeRequestDto dto);

    Office updateEntityFromDto(OfficeRequestDto dto, Office office);
}
