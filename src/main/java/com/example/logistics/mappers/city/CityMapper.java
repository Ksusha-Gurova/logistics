package com.example.logistics.mappers.city;

import com.example.logistics.api.dto.city.CityResponseDto;
import com.example.logistics.model.City;

public interface CityMapper {
    CityResponseDto mapEntityToDto(City city);
}
