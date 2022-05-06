package com.example.logistics.service.courier;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.model.Courier;

import java.util.List;

public interface CourierService {
    List<Courier> findAll();

    Courier findCourier(Long id);

    Courier updateCourier(CourierRequestDto dto);

    Courier saveNewCourier(CourierRequestDto dto);

    void deleteCourier(Long id);
}
