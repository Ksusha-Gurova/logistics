package com.example.logistics.service.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.model.Package;

import java.util.List;

public interface PackageService {
    List<Package> findAll();

    Package findPackage(Long id);

    Package updatePackage(PackageRequestDto pac);

    Package saveNewPackage(PackageRequestDto pac);

    void deletePackage(Long id);
}
