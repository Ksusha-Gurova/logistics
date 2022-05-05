package com.example.logistics.service.client;

import com.example.logistics.dto.client.ClientRequestDto;
import com.example.logistics.entity.Client;
import com.example.logistics.mappers.client.ClientMapper;
import com.example.logistics.repository.ClientRepository;
import com.example.logistics.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Override
    public List<Client> findAll() {
        List<Client> allClient = clientRepository.findAll();
        return allClient;
    }

    @Override
    public Client findClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.get();
    }

    @Override
    public Client updateClient(ClientRequestDto clientDto) {
        Client client = clientRepository.getById(clientDto.getId());
        if (client != null){
            return clientRepository.save(mapper.updateEntityFromDto(clientDto, client));
        } else return saveNewClient(clientDto);
    }

    @Override
    public Client saveNewClient(ClientRequestDto dto) {
        return clientRepository.save(mapper.mapDtoToEntity(dto));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
