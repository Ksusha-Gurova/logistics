package com.example.logistics.service.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.dto.packag.PackageResponseDto;
import com.example.logistics.model.Package;

import java.util.List;

public interface PackageService {
    List<PackageResponseDto> findAll();

    PackageResponseDto findPackage(Long id);

    PackageResponseDto updatePackage(PackageRequestDto pac);

    PackageResponseDto saveNewPackage(PackageRequestDto pac);

    void deletePackage(Long id);
}
