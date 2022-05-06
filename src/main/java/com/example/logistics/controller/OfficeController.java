package com.example.logistics.controller;


import com.example.logistics.dto.office.OfficeRequestDto;
import com.example.logistics.dto.office.OfficeResponseDto;
import com.example.logistics.model.Office;
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

    @PutMapping("/{id}")
    public OfficeResponseDto updateOffice (@RequestBody OfficeRequestDto dto){
        return officeService.updateOffice(dto);
    }

    @PostMapping
    public OfficeResponseDto saveNewOffice (@RequestBody OfficeRequestDto dto){
        return officeService.saveNewOffice(dto);
    }

    @DeleteMapping("{id}")
    public void deleteOffice (@PathVariable Long id){
        officeService.deleteOffice(id);
    }
}
