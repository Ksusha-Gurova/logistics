package com.example.logistics.service.client;

import com.example.logistics.api.dto.request.ClientRequestDto;
import com.example.logistics.api.dto.response.ClientResponseDto;
import com.example.logistics.model.Client;
import com.example.logistics.mappers.client.ClientMapper;
import com.example.logistics.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    public ClientResponseDto saveOrUpdatePackage(ClientRequestDto dto) {
        Client updetedOrNewClient = Optional.ofNullable(dto.getId())
                .map(clientId -> clientRepository.findById(clientId)
                        .map(client -> mapper.updateEntityFromDto(dto, client))
                        .orElseThrow(() -> new EntityNotFoundException("Не существует в базе клиента с id = " + dto.getId())))
                .orElse(mapper.mapDtoToEntity(dto));
        updetedOrNewClient = clientRepository.save(updetedOrNewClient);

        return mapper.mapEntityToDto(updetedOrNewClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
