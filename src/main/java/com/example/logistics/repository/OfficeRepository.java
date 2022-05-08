package com.example.logistics.repository;

import com.example.logistics.model.City;
import com.example.logistics.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Long> {
    List<Office> findAllByCity (City city);
}
