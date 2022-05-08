package com.example.logistics.mappers.city;

import com.example.logistics.api.dto.city.CityResponseDto;
import com.example.logistics.model.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapperImpl implements CityMapper {
    @Override
    public CityResponseDto mapEntityToDto(City city) {
        return CityResponseDto.builder()
                .name(city.name())
                .russianName(city.getTranslation())
                .build();
    }
}