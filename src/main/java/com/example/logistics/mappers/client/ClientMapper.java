package com.example.logistics.mappers.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.entity.Client;

public interface ClientMapper {
    Client mapDtoToEntity(ClientRequestDto dto);

    Client updateEntityFromDto(ClientRequestDto dto, Client client);
}
