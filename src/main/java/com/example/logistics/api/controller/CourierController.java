package com.example.logistics.api.controller;

import com.example.logistics.api.dto.request.CourierRequestDto;
import com.example.logistics.api.dto.response.CourierResponseDto;
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

    @PostMapping
    public CourierResponseDto saveOrUpdateCourier (@RequestBody CourierRequestDto dto) {
        return courierService.saveOrUpdateCourier(dto);
    }

    @DeleteMapping("{id}")
    public void deleteCourier (@PathVariable Long id){
        courierService.deleteCourier(id);
    }
}
