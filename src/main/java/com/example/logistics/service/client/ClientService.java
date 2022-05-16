package com.example.logistics.service.client;

import org.openapitools.model.ClientRequestDto;
import org.openapitools.model.ClientResponseDto;

import java.util.List;

public interface ClientService {
    List<ClientResponseDto> findAll();

    ClientResponseDto findClient(Long id);

    ClientResponseDto saveOrUpdatePackage(ClientRequestDto dto);

    void deleteClient(Long id);
}
