package com.example.logistics.dto.client;

import com.example.logistics.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequestDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String address;
    private String city ;
}
