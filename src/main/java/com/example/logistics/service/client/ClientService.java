package com.example.logistics.service.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.dto.client.ClientResponseDto;

import java.util.List;

public interface ClientService {
    List<ClientResponseDto> findAll();

    ClientResponseDto findClient(Long id);

    ClientResponseDto saveOrUpdatePackage(ClientRequestDto dto);

    void deleteClient(Long id);
}
