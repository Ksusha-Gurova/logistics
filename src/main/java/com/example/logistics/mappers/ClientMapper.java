package com.example.logistics.mappers;

import com.example.logistics.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.ClientRequestDto;
import org.openapitools.model.ClientResponseDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client mapDtoToEntity(ClientRequestDto dto);

    @Mapping(target = "id", ignore = true)
    Client updateEntityFromDto(ClientRequestDto dto, @MappingTarget Client client);

    @Mapping(source = "city.translation", target = "city")
    ClientResponseDto mapEntityToDto(Client client);
}
