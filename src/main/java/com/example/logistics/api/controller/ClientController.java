package com.example.logistics.api.controller;

import com.example.logistics.api.dto.client.ClientRequestDto;
import com.example.logistics.api.dto.client.ClientResponseDto;
import com.example.logistics.service.client.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponseDto> findAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientResponseDto findClient(@PathVariable Long id){
        return clientService.findClient(id);
    }

    @PostMapping
    public ClientResponseDto saveOrUpdateClient (ClientRequestDto dto) {
        return clientService.saveOrUpdatePackage(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient (@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
