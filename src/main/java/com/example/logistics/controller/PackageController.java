package com.example.logistics.controller;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.model.Package;
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
    public List<Package> findAllPackages (){
        return packageService.findAll();
    }

    @GetMapping("/{id}")
    public Package findPackage (@PathVariable Long id){
        return packageService.findPackage(id);
    }

    @PutMapping("/{id}")
    public Package updatePackage (@RequestBody PackageRequestDto pac){
        return packageService.updatePackage(pac);
    }

    @PostMapping
    public Package saveNewPackage (@RequestBody PackageRequestDto pac){
        return packageService.saveNewPackage(pac);
    }

    @DeleteMapping("{id}")
    public void deletePackage (@PathVariable Long id){
        packageService.deletePackage(id);
    }
}
