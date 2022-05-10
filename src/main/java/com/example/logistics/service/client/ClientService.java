package com.example.logistics.service.client;

import com.example.logistics.api.dto.request.ClientRequestDto;
import com.example.logistics.api.dto.response.ClientResponseDto;

import java.util.List;

public interface ClientService {
    List<ClientResponseDto> findAll();

    ClientResponseDto findClient(Long id);

    ClientResponseDto saveOrUpdatePackage(ClientRequestDto dto);

    void deleteClient(Long id);
}
