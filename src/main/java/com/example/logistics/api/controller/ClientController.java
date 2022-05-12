package com.example.logistics.api.controller;

import com.example.logistics.api.dto.request.ClientRequestDto;
import com.example.logistics.api.dto.response.ClientResponseDto;
import com.example.logistics.service.client.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponseDto> findAllClients(){
        log.info("findAllClients()");
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientResponseDto findClient(@PathVariable Long id){
        log.info("findClient(), id = {}", id);
        return clientService.findClient(id);
    }

    @PostMapping
    public ClientResponseDto saveOrUpdateClient (ClientRequestDto dto) {
        log.info("saveOrUpdateClient(), dto = {}", dto);
        return clientService.saveOrUpdatePackage(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient (@PathVariable Long id) {
        log.info("deleteClient(), il = {}", id);
        clientService.deleteClient(id);
    }
}
