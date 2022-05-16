package com.example.logistics.api.controller;

import com.example.logistics.service.courier.CourierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.CourierApi;
import org.openapitools.model.CourierRequestDto;
import org.openapitools.model.CourierResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CourierController implements CourierApi {
    private final CourierService courierService;

    @Override
    public ResponseEntity<Void> deleteCourier(Long id) {
        courierService.deleteCourier(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<CourierResponseDto>> findAllCouriers() {
        return ResponseEntity.ok(courierService.findAll());
    }

    @Override
    public ResponseEntity<CourierResponseDto> findCourier(Long id) {
        return ResponseEntity.ok(courierService.findCourier(id));
    }

    @Override
    public ResponseEntity<CourierResponseDto> saveOrUpdateCourier(CourierRequestDto courierRequestDto) {
        return ResponseEntity.ok(courierService.saveOrUpdateCourier(courierRequestDto));
    }
}
