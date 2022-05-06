package com.example.logistics.controller;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.dto.courier.CourierResponseDto;
import com.example.logistics.model.Courier;
import com.example.logistics.service.courier.CourierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {
    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping
    public List<CourierResponseDto> findAllCouriers (){
        return courierService.findAll();
    }
    @GetMapping("/{id}")
    public CourierResponseDto findCourier (@PathVariable Long id){
        return courierService.findCourier(id);
    }

    @PutMapping("/{id}")
    public CourierResponseDto updateCourier (@RequestBody CourierRequestDto dto){
        return courierService.updateCourier(dto);
    }

    @PostMapping
    public CourierResponseDto saveNewCourier (@RequestBody CourierRequestDto dto){
        return courierService.saveNewCourier(dto);
    }

    @DeleteMapping("{id}")
    public void deleteCourier (@PathVariable Long id){
        courierService.deleteCourier(id);
    }
}
