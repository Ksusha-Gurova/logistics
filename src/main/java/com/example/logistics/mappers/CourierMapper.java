package com.example.logistics.mappers;

import com.example.logistics.api.dto.request.CourierRequestDto;
import com.example.logistics.api.dto.response.CourierResponseDto;
import com.example.logistics.model.Courier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourierMapper {
    Courier mapDtoToEntity(CourierRequestDto dto);

    @Mapping(target = "id", ignore = true)
    Courier updateEntityFromDto(CourierRequestDto dto, @MappingTarget Courier courier);

    @Mapping(source = "city.translation", target = "city")
    CourierResponseDto mapEntityToDto (Courier courier);
}
