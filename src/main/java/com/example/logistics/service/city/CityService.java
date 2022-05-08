package com.example.logistics.service.city;

import com.example.logistics.api.dto.city.CityResponseDto;

import java.util.List;

public interface CityService {
    List<CityResponseDto> findAllCities();
}
