package com.example.logistics.controller;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.dto.client.ClientResponseDto;
import com.example.logistics.model.Client;
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

    @PutMapping("/{id}")
    public ClientResponseDto updateClient (@RequestBody ClientRequestDto dto){
        return clientService.updateClient(dto);
    }

    @PostMapping
    public ClientResponseDto saveNewClient (@RequestBody ClientRequestDto dto){
        return clientService.saveNewClient(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient (@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
