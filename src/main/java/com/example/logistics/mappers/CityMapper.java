package com.example.logistics.mappers;

import com.example.logistics.api.dto.response.CityResponseDto;
import com.example.logistics.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mapping(source = "translation", target = "russianName")
    @Mapping(source = "city", target = "name")
    CityResponseDto mapEntityToDto(City city);
}
