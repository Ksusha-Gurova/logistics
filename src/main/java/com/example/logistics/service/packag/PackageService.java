package com.example.logistics.service.packag;

import com.example.logistics.api.dto.packag.PackageRequestDto;
import com.example.logistics.api.dto.packag.PackageResponseDto;

import java.util.List;

public interface PackageService {
    List<PackageResponseDto> findAll();

    PackageResponseDto findPackage(Long id);

    PackageResponseDto saveOrUpdatePackage (PackageRequestDto dto);

    void deletePackage(Long id);

    List<PackageResponseDto> findAllPackagesFromClient(Long id);

    List<PackageResponseDto> findAllPackagesToClient(Long id);

    List<PackageResponseDto> findPackagesFromOffice(Long id);

    List<PackageResponseDto> findPackagesToOffice(Long id);

    List<PackageResponseDto> findPackagesByStatus(String status);

    List<PackageResponseDto> findPackagesByCourier(Long courierID);
}
