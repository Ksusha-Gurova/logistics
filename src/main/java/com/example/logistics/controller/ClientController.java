package com.example.logistics.controller;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.entity.Client;
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
    public List<Client> findAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findClient(@PathVariable Long id){
        return clientService.findClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClient (@RequestBody ClientRequestDto dto){
        return clientService.updateClient(dto);
    }

    @PostMapping
    public Client saveNewClient (@RequestBody ClientRequestDto dto){
        return clientService.saveNewClient(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient (@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
