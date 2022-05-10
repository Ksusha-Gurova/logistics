package com.example.logistics.mappers;

import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;
import com.example.logistics.model.Office;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OfficeMapper {
    Office mapDtoToEntity(OfficeRequestDto dto);

    @Mapping(target = "id", ignore = true)
    Office updateEntityFromDto(OfficeRequestDto dto, @MappingTarget Office office);

    @Mapping(source = "city.translation", target = "city")
    OfficeResponseDto mapEntityToDto(Office office);
}
