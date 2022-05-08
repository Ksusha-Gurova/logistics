package com.example.logistics.api.dto.courier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CourierResponseDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String city;
}
