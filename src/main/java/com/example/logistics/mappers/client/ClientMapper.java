package com.example.logistics.mappers.client;

import com.example.logistics.api.dto.request.ClientRequestDto;
import com.example.logistics.api.dto.response.ClientResponseDto;
import com.example.logistics.model.Client;

public interface ClientMapper {
    Client mapDtoToEntity(ClientRequestDto dto);

    Client updateEntityFromDto(ClientRequestDto dto, Client client);

    ClientResponseDto mapEntityToDto(Client client);
}
