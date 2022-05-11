package com.example.logistics.service.client;

import com.example.logistics.api.dto.request.ClientRequestDto;
import com.example.logistics.api.dto.response.ClientResponseDto;
import com.example.logistics.model.Client;
import com.example.logistics.mappers.ClientMapper;
import com.example.logistics.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
        log.info("saveOrUpdateClient(), dto = {}", dto);
        try {
            Client updatedOrNewClient = Optional.ofNullable(dto.getId())
                    .map(clientId -> clientRepository.findById(clientId)
                            .map(client -> mapper.updateEntityFromDto(dto, client))
                            .orElseThrow(() -> new EntityNotFoundException("Не существует в базе клиента с id = " + dto.getId())))
                    .orElse(mapper.mapDtoToEntity(dto));
            updatedOrNewClient = clientRepository.save(updatedOrNewClient);
            log.info("saveOrUpdatePackage(), в базу сохранен Client, updatedOrNewClient = {}", updatedOrNewClient);


            ClientResponseDto clientResponseDto = mapper.mapEntityToDto(updatedOrNewClient);
            log.info("saveOrUpdatePackage(), return value = {}", clientResponseDto);
            return clientResponseDto;

        } catch (DataAccessException e){
            log.error("saveOrUpdatePackage(), ошибка сохронения в базу");
            throw new PersistenceException("В ходе обработки запроса произошла ошибка: " + e.getMessage());
        }

    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
