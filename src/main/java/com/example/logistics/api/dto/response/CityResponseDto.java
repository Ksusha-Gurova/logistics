package com.example.logistics.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CityResponseDto {
    private String name;
    private String russianName;
}
