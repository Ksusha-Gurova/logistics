package com.example.logistics.mappers.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.model.City;
import com.example.logistics.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapper{
    @Override
    public Client mapDtoToEntity(ClientRequestDto dto) {
        return Client.builder()
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .city(City.valueOf(dto.getCity()))
                .build();
    }

    @Override
    public Client updateEntityFromDto(ClientRequestDto dto, Client client) {
        client.setSurname(dto.getSurname());
        client.setName(dto.getName());
        client.setPatronymic(dto.getPatronymic());
        client.setPhone(dto.getPhone());
        client.setAddress(dto.getAddress());
        client.setCity(City.valueOf(dto.getCity()));
        return client;
    }
}
