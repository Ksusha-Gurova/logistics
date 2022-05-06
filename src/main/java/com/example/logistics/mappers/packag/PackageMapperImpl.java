package com.example.logistics.mappers.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.dto.packag.PackageResponseDto;
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
                .fromClientId(fromClient)
                .toClientId(toClient)
                .fromOfficeId(fromOffice)
                .toOfficeId(toOffice)
                .courierId(courier)
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
        pac.setFromClientId(fromClient);
        pac.setToClientId(toClient);
        pac.setFromOfficeId(fromOffice);
        pac.setToOfficeId(toOffice);
        pac.setCourierId(courier);
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
                .fromClientId(pac.getFromClientId().getId())
                .toClientId(pac.getToClientId().getId())
                .fromOfficeId(pac.getFromOfficeId().getId())
                .toOfficeId(pac.getToOfficeId().getId())
                .courierId(Optional.ofNullable(pac.getCourierId()).map(Courier::getId).orElse(null))
                .dateOfReceipt(pac.getDateOfReceipt())
                .dateOfIssue(pac.getDateOfIssue())
                .build();
    }
}
