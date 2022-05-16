package com.example.logistics.service.courier;

import org.openapitools.model.CourierRequestDto;
import org.openapitools.model.CourierResponseDto;

import java.util.List;

public interface CourierService {
    List<CourierResponseDto> findAll();

    CourierResponseDto findCourier(Long id);

    CourierResponseDto saveOrUpdateCourier(CourierRequestDto dto);

    void deleteCourier(Long id);
}
