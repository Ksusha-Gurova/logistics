package com.example.logistics.repository;

import com.example.logistics.model.Package;
import com.example.logistics.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, Long> {
    List<Package> findAllByFromClient_Id(Long clientId);

    List<Package> findAllByToClient_Id(Long clientId);

    List<Package> findAllByFromOffice_Id(Long id);

    List<Package> findAllByToOffice_Id(Long id);

    List<Package> findAllByStatus(Status status);

    List<Package> findAllByCourier_Id(Long id);
}
