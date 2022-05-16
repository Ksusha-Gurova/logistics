package com.example.logistics.api.controller;//package com.example.logistics.api.controller;

import com.example.logistics.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.ClientApi;
import org.openapitools.model.ClientRequestDto;
import org.openapitools.model.ClientResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {
    private final ClientService clientService;

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ClientResponseDto>> findAllClients() {
        log.info("findAllClients()");
        return ResponseEntity.ok(clientService.findAll());
    }

    @Override
    public ResponseEntity<ClientResponseDto> findClients(Long id) {
        log.info("findClient(), id = {}", id);
        return ResponseEntity.ok(clientService.findClient(id));
    }

    @Override
    public ResponseEntity<ClientResponseDto> saveOrUpdateClient(ClientRequestDto clientRequestDto) {
        log.info("saveOrUpdateClient(), dto = {}", clientRequestDto);
        return ResponseEntity.ok(clientService.saveOrUpdatePackage(clientRequestDto));
    }
}
