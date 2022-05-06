package com.example.logistics.service.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.dto.client.ClientResponseDto;
import com.example.logistics.model.Client;

import java.util.List;

public interface ClientService {
    List<ClientResponseDto> findAll();

    ClientResponseDto findClient(Long id);

    ClientResponseDto updateClient(ClientRequestDto dto);

    ClientResponseDto saveNewClient(ClientRequestDto dto);

    void deleteClient(Long id);
}
