package com.example.logistics.api.controller;


import com.example.logistics.api.dto.request.OfficeRequestDto;
import com.example.logistics.api.dto.response.OfficeResponseDto;
import com.example.logistics.service.office.OfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/office")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<OfficeResponseDto> findAllOffices (){
        log.info("findAllOffices()");
        return officeService.findAll();
    }

    @GetMapping("/{id}")
    public OfficeResponseDto findOffice (@PathVariable Long id){
        log.info("findOffice(), id = {}", id);
        return officeService.findOffice(id);
    }

    @PostMapping
    public OfficeResponseDto saveOrUpdateOffice (@RequestBody OfficeRequestDto dto) {
        log.info("saveOrUpdateOffice(), dto = {}", dto);
        return officeService.saveOrUpdateOffice(dto);
    }

    @DeleteMapping("{id}")
    public void deleteOffice (@PathVariable Long id){
        log.info("deleteOffice(), id = {}", id);
        officeService.deleteOffice(id);
    }

    @GetMapping("/by_city")
    public List<OfficeResponseDto> findOfficesByCity(String city){
        log.info("findOfficesByCity(), city = {}", city);
        return officeService.findOfficesByCity(city);
    }
}
