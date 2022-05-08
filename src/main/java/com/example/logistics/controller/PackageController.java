package com.example.logistics.controller;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.dto.packag.PackageResponseDto;
import com.example.logistics.service.packag.PackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController {
    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public List<PackageResponseDto> findAllPackages (){
        return packageService.findAll();
    }

    @GetMapping("/{id}")
    public PackageResponseDto findPackage (@PathVariable Long id){
        return packageService.findPackage(id);
    }

    @PostMapping
    public PackageResponseDto saveOrUpdatePackage (@RequestBody PackageRequestDto dto){
        return packageService.saveOrUpdatePackage(dto);
    }

    @DeleteMapping("{id}")
    public void deletePackage (@PathVariable Long id){
        packageService.deletePackage(id);
    }
}
