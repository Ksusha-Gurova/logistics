package com.example.logistics.dto.courier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourierRequestDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String city;
}
