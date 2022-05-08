package com.example.logistics.api.dto.packag;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PackageRequestDto {
    private Long id;
    private String size;
    private Double weight;
    private String status;
    private Long fromClientId;
    private Long toClientId;
    private Long fromOfficeId;
    private Long toOfficeId;
    private Long courierId;

    private LocalDate dateOfReceipt;
    private LocalDate dateOfIssue;
}
