package com.example.logistics.service.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.dto.packag.PackageResponseDto;

import java.util.List;

public interface PackageService {
    List<PackageResponseDto> findAll();

    PackageResponseDto findPackage(Long id);

    PackageResponseDto saveOrUpdatePackage (PackageRequestDto dto);

    void deletePackage(Long id);
}
