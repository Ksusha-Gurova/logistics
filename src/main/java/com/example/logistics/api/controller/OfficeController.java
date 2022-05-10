package com.example.logistics.api.controller;


import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;
import com.example.logistics.service.office.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<OfficeResponseDto> findAllOffices (){
        return officeService.findAll();
    }

    @GetMapping("/{id}")
    public OfficeResponseDto findOffice (@PathVariable Long id){
        return officeService.findOffice(id);
    }

    @PostMapping
    public OfficeResponseDto saveOrUpdateOffice (@RequestBody OfficeRequestDto dto) {
        return officeService.saveOrUpdateOffice(dto);
    }

    @DeleteMapping("{id}")
    public void deleteOffice (@PathVariable Long id){
        officeService.deleteOffice(id);
    }

    @GetMapping("/by_city")
    public List<OfficeResponseDto> findOfficesByCity(String city){
        return officeService.findOfficesByCity(city);
    }
}
