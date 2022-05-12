package com.example.logistics.service.city;

import com.example.logistics.api.dto.response.CityResponseDto;
import com.example.logistics.mappers.CityMapper;
import com.example.logistics.model.City;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService{
    private final CityMapper mapper;
    @Override
    public List<CityResponseDto> findAllCities() {
        log.info("findAllCities()");
        return Arrays.stream(City.values()).map(mapper::mapEntityToDto).collect(Collectors.toList());
    }
}
