package com.example.logistics.service.city;

import com.example.logistics.api.dto.city.CityResponseDto;
import com.example.logistics.mappers.city.CityMapper;
import com.example.logistics.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService{
    private final CityMapper mapper;
    @Override
    public List<CityResponseDto> findAllCities() {
        return Arrays.stream(City.values()).map(mapper::mapEntityToDto).collect(Collectors.toList());
    }
}
