package com.example.logistics.service.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findClient(Long id);

    Client updateClient(ClientRequestDto dto);

    Client saveNewClient(ClientRequestDto dto);

    void deleteClient(Long id);
}
