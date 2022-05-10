package com.example.logistics.mappers.courier;

import com.example.logistics.api.dto.request.CourierRequestDto;
import com.example.logistics.api.dto.response.CourierResponseDto;
import com.example.logistics.model.City;
import com.example.logistics.model.Courier;
import org.springframework.stereotype.Component;

@Component
public class CourierMapperImpl implements CourierMapper{
    @Override
    public Courier mapDtoToEntity(CourierRequestDto dto) {
        return Courier.builder()
                .id(dto.getId())
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

    @Override
    public CourierResponseDto mapEntityToDto(Courier courier) {
        return CourierResponseDto.builder()
                .id(courier.getId())
                .surname(courier.getSurname())
                .name(courier.getName())
                .patronymic(courier.getPatronymic())
                .phone(courier.getPhone())
                .city(courier.getCity().getTranslation())
                .build();
    }
}
