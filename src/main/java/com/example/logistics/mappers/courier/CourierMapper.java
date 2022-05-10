package com.example.logistics.mappers.courier;

import com.example.logistics.api.dto.request.CourierRequestDto;
import com.example.logistics.api.dto.response.CourierResponseDto;
import com.example.logistics.model.Courier;

public interface CourierMapper {
    Courier mapDtoToEntity(CourierRequestDto dto);

    Courier updateEntityFromDto(CourierRequestDto dto, Courier courier);

    CourierResponseDto mapEntityToDto (Courier courier);
}
