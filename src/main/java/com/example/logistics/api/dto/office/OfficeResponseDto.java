package com.example.logistics.api.dto.office;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OfficeResponseDto {
    private Long id;
    private String address;
    private String phone;
    private String city;
}
