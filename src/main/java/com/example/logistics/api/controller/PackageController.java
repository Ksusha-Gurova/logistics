package com.example.logistics.api.controller;

import com.example.logistics.api.dto.request.PackageRequestDto;
import com.example.logistics.api.dto.response.PackageResponseDto;
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
    public void deletePackage(@PathVariable Long id){
        packageService.deletePackage(id);
    }

    @GetMapping("/from_client/{clientId}")
    public List<PackageResponseDto> findAllPackagesFromClient(@PathVariable Long clientId){
        return packageService.findAllPackagesFromClient(clientId);
    }

    @GetMapping("/to_client/{clientId}")
    public List<PackageResponseDto> findPackagesToClient(@PathVariable Long clientId){
        return packageService.findAllPackagesToClient(clientId);
    }

    @GetMapping("/from_office/{officeId}")
    public List<PackageResponseDto> findPackagesFromOffice(@PathVariable Long officeId){
        return packageService.findPackagesFromOffice(officeId);
    }

    @GetMapping("/to_office/{officeId}")
    public List<PackageResponseDto> findPackagesToOffice(@PathVariable Long officeId){
        return packageService.findPackagesToOffice(officeId);
    }

    @GetMapping("/by_status")
    public List<PackageResponseDto> findPackagesByStatus(@RequestParam String status){
        return packageService.findPackagesByStatus(status);
    }

    @GetMapping("/by_courier")
    public List<PackageResponseDto> findPackagesByCourier(@RequestParam Long courierID){
        return packageService.findPackagesByCourier(courierID);
    }
}
