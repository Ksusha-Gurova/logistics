package com.example.logistics.mappers;

import com.example.logistics.api.dto.request.PackageRequestDto;
import com.example.logistics.api.dto.response.PackageResponseDto;
import com.example.logistics.model.Client;
import com.example.logistics.model.Courier;
import com.example.logistics.model.Office;
import com.example.logistics.model.Package;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PackageMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "fromClient", target = "fromClient")
    @Mapping(source = "toClient", target = "toClient")
    @Mapping(source = "fromOffice", target = "fromOffice")
    @Mapping(source = "toOffice", target = "toOffice")
    @Mapping(source = "courier", target = "courier")
    Package mapDtoToEntity(
            PackageRequestDto dto,
            Office toOffice,
            Office fromOffice,
            Client toClient,
            Client fromClient,
            Courier courier);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "fromClient", target = "pac.fromClient")
    @Mapping(source = "toClient", target = "pac.toClient")
    @Mapping(source = "fromOffice", target = "pac.fromOffice")
    @Mapping(source = "toOffice", target = "pac.toOffice")
    @Mapping(source = "courier", target = "pac.courier")
    Package updateEntityFromDto(
            @MappingTarget Package pac,
            PackageRequestDto dto,
            Office toOffice,
            Office fromOffice,
            Client toClient,
            Client fromClient,
            Courier courier);

    @Mapping(source = "fromClient.id", target = "fromClientId")
    @Mapping(source = "toClient.id", target = "toClientId")
    @Mapping(source = "fromOffice.id", target = "fromOfficeId")
    @Mapping(source = "toOffice.id", target = "toOfficeId")
    @Mapping(source = "courier.id", target = "courierId")
    PackageResponseDto mapEntityToDto(Package pac);
}
