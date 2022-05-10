package com.example.logistics.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OfficeRequestDto {
    private Long id;
    private String address;
    private String phone;
    private String city;
}
