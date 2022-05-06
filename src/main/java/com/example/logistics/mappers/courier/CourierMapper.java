package com.example.logistics.mappers.courier;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.model.Courier;

public interface CourierMapper {
    Courier mapDtoToEntity(CourierRequestDto dto);

    Courier updateEntityFromDto(CourierRequestDto dto, Courier courier);
}
