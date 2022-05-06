package com.example.logistics.dto.packag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class PackageResponseDto {
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
