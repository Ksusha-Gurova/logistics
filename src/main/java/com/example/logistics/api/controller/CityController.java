package com.example.logistics.api.controller;

import com.example.logistics.api.dto.city.CityResponseDto;
import com.example.logistics.service.city.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityResponseDto> findAllCities(){
        return cityService.findAllCities();
    }
}