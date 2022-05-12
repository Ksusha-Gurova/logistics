package com.example.logistics.api.controller;

import com.example.logistics.api.dto.request.PackageRequestDto;
import com.example.logistics.api.dto.response.PackageResponseDto;
import com.example.logistics.service.packag.PackageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/package")
public class PackageController {
    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public List<PackageResponseDto> findAllPackages (){
        log.info("");
        return packageService.findAll();
    }

    @GetMapping("/{id}")
    public PackageResponseDto findPackage (@PathVariable Long id){
        log.info("findAllPackages(), id = {}", id);
        return packageService.findPackage(id);
    }

    @PostMapping
    public PackageResponseDto saveOrUpdatePackage (@RequestBody PackageRequestDto dto){
        log.info("saveOrUpdatePackage(), dto = {}", dto);
        return packageService.saveOrUpdatePackage(dto);
    }

    @DeleteMapping("{id}")
    public void deletePackage(@PathVariable Long id){
        log.info("deletePackage(), id = {}", id);
        packageService.deletePackage(id);
    }

    @GetMapping("/from_client/{clientId}")
    public List<PackageResponseDto> findAllPackagesFromClient(@PathVariable Long clientId){
        log.info("findAllPackagesFromClient(), clientId = {}", clientId);
        return packageService.findAllPackagesFromClient(clientId);
    }

    @GetMapping("/to_client/{clientId}")
    public List<PackageResponseDto> findPackagesToClient(@PathVariable Long clientId){
        log.info("findPackagesToClient(), clientId = {}", clientId);
        return packageService.findAllPackagesToClient(clientId);
    }

    @GetMapping("/from_office/{officeId}")
    public List<PackageResponseDto> findPackagesFromOffice(@PathVariable Long officeId){
        log.info("findPackagesFromOffice(), officeId = {}", officeId);
        return packageService.findPackagesFromOffice(officeId);
    }

    @GetMapping("/to_office/{officeId}")
    public List<PackageResponseDto> findPackagesToOffice(@PathVariable Long officeId){
        log.info("findPackagesToOffice(), officeId = {}", officeId);
        return packageService.findPackagesToOffice(officeId);
    }

    @GetMapping("/by_status")
    public List<PackageResponseDto> findPackagesByStatus(@RequestParam String status){
        log.info("findPackagesByStatus(), status = {}", status);
        return packageService.findPackagesByStatus(status);
    }

    @GetMapping("/by_courier")
    public List<PackageResponseDto> findPackagesByCourier(@RequestParam Long courierID){
        log.info("findPackagesByCourier(), courierID = {}", courierID);
        return packageService.findPackagesByCourier(courierID);
    }
}
