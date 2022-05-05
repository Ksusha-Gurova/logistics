package com.example.logistics.dto.office;

import com.example.logistics.entity.City;
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
