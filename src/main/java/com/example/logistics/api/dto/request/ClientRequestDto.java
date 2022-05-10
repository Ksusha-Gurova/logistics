package com.example.logistics.api.dto.request;

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