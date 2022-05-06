package com.example.logistics.service.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.dto.client.ClientResponseDto;
import com.example.logistics.model.Client;
import com.example.logistics.mappers.client.ClientMapper;
import com.example.logistics.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Override
    public List<ClientResponseDto> findAll() {
        return clientRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto findClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public ClientResponseDto updateClient(ClientRequestDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).orElse(null);
        if (client != null){
            Client updatedClient = clientRepository.save(mapper.updateEntityFromDto(clientDto, client));
            return mapper.mapEntityToDto(updatedClient);
        } else return saveNewClient(clientDto);
    }

    @Override
    public ClientResponseDto saveNewClient(ClientRequestDto dto) {
        Client newClient = clientRepository.save(mapper.mapDtoToEntity(dto));
        return mapper.mapEntityToDto(newClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
