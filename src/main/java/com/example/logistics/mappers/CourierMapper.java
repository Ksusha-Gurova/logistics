package com.example.logistics.mappers;

import com.example.logistics.model.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.CourierRequestDto;
import org.openapitools.model.CourierResponseDto;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier mapDtoToEntity(CourierRequestDto dto);

    @Mapping(target = "id", ignore = true)
    Courier updateEntityFromDto(CourierRequestDto dto, @MappingTarget Courier courier);

    @Mapping(source = "city.translation", target = "city")
    CourierResponseDto mapEntityToDto (Courier courier);
}
