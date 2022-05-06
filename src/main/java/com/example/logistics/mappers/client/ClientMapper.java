package com.example.logistics.mappers.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.model.Client;

public interface ClientMapper {
    Client mapDtoToEntity(ClientRequestDto dto);

    Client updateEntityFromDto(ClientRequestDto dto, Client client);
}
