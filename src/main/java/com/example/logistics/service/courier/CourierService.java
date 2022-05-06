package com.example.logistics.service.courier;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.dto.courier.CourierResponseDto;
import com.example.logistics.model.Courier;

import java.util.List;

public interface CourierService {
    List<CourierResponseDto> findAll();

    CourierResponseDto findCourier(Long id);

    CourierResponseDto updateCourier(CourierRequestDto dto);

    CourierResponseDto saveNewCourier(CourierRequestDto dto);

    void deleteCourier(Long id);
}
