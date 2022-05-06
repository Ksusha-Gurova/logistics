package com.example.logistics.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String address;
    private String city ;
}
