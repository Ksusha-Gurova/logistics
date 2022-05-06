package com.example.logistics.dto.office;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OfficeResponseDto {
    private Long id;
    private String address;
    private String phone;
    private String city;
}
