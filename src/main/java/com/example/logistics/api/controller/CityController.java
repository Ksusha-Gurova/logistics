package com.example.logistics.api.controller;

import com.example.logistics.api.dto.response.CityResponseDto;
import com.example.logistics.service.city.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityResponseDto> findAllCities(){
        log.info("findAllCities()");
        return cityService.findAllCities();
    }
}
