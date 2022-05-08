package com.example.logistics.service.courier;

import com.example.logistics.api.dto.courier.CourierRequestDto;
import com.example.logistics.api.dto.courier.CourierResponseDto;

import java.util.List;

public interface CourierService {
    List<CourierResponseDto> findAll();

    CourierResponseDto findCourier(Long id);

    CourierResponseDto saveOrUpdateCourier(CourierRequestDto dto);

    void deleteCourier(Long id);
}
