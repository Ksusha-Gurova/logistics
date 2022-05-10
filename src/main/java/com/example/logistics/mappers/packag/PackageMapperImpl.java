package com.example.logistics.mappers.packag;

import com.example.logistics.api.dto.request.PackageRequestDto;
import com.example.logistics.api.dto.response.PackageResponseDto;
import com.example.logistics.model.*;
import com.example.logistics.model.Package;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PackageMapperImpl implements PackageMapper {
    @Override
    public Package mapDtoToEntity(
            PackageRequestDto dto,
            Office toOffice,
            Office fromOffice,
            Client toClient,
            Client fromClient,
            Courier courier) {
        return Package.builder()
                .id(dto.getId())
                .size(SizeBox.valueOf(dto.getSize()))
                .weight(dto.getWeight())
                .status(Status.valueOf(dto.getStatus()))
                .fromClient(fromClient)
                .toClient(toClient)
                .fromOffice(fromOffice)
                .toOffice(toOffice)
                .courier(courier)
                .dateOfReceipt(dto.getDateOfReceipt())
                .dateOfIssue(dto.getDateOfIssue())
                .build();
    }

    @Override
    public Package updateEntityFromDto(
            Package pac,
            PackageRequestDto dto,
            Office toOffice,
            Office fromOffice,
            Client toClient,
            Client fromClient,
            Courier courier) {
        pac.setSize(SizeBox.valueOf(dto.getSize()));
        pac.setWeight(dto.getWeight());
        pac.setStatus(Status.valueOf(dto.getStatus()));
        pac.setFromClient(fromClient);
        pac.setToClient(toClient);
        pac.setFromOffice(fromOffice);
        pac.setToOffice(toOffice);
        pac.setCourier(courier);
        pac.setDateOfIssue(dto.getDateOfIssue());

        return pac;
    }

    @Override
    public PackageResponseDto mapEntityToDto(Package pac) {
        return PackageResponseDto.builder()
                .id(pac.getId())
                .size(pac.getSize().toString())
                .weight(pac.getWeight())
                .status(pac.getStatus().getMessage())
                .fromClientId(pac.getFromClient().getId())
                .toClientId(pac.getToClient().getId())
                .fromOfficeId(pac.getFromOffice().getId())
                .toOfficeId(pac.getToOffice().getId())
                .courierId(Optional.ofNullable(pac.getCourier()).map(Courier::getId).orElse(null))
                .dateOfReceipt(pac.getDateOfReceipt())
                .dateOfIssue(pac.getDateOfIssue())
                .build();
    }
}
