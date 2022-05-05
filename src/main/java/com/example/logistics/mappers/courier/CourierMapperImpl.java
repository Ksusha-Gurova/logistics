package com.example.logistics.mappers.courier;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.entity.City;
import com.example.logistics.entity.Courier;
import org.springframework.stereotype.Component;

@Component
public class CourierMapperImpl implements CourierMapper{
    @Override
    public Courier mapDtoToEntity(CourierRequestDto dto) {
        return Courier.builder()
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .phone(dto.getPhone())
                .city(City.valueOf(dto.getCity()))
                .build();
    }

    @Override
    public Courier updateEntityFromDto(CourierRequestDto dto, Courier courier) {
        courier.setSurname(dto.getSurname());
        courier.setName(dto.getName());
        courier.setPatronymic(dto.getPatronymic());
        courier.setPhone(dto.getPhone());
        courier.setCity(City.valueOf(dto.getCity()));
        return courier;
    }
}
