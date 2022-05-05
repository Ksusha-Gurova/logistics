package com.example.logistics.mappers.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.entity.*;
import com.example.logistics.entity.Package;
import com.example.logistics.mappers.packag.PackageMapper;
import org.springframework.stereotype.Component;

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
}
//        Client toClient = clientRepository.getById(pac.getToClientId());
//        Client fromClient = clientRepository.getById(pac.getFromClientId());
//        Office toOffice = officeRepository.getById(pac.getToOfficeId());
//        Office fromOffice = officeRepository.getById(pac.getFromOfficeId());
//        Courier courier = courierRepository.getById(pac.getCourierId());
//        SizeBox size = SizeBox.valueOf(pac.getSize());
//        Status status = Status.valueOf(pac.getStatus());
//
//        Package pack = Package.builder()
//                .id(null)
//                .size(size)
//                .weight(pac.getWeight())
//                .status(status)
//                .fromClientId(fromClient)
//                .toClientId(toClient)
//                .fromOfficeId(fromOffice)
//                .toOfficeId(toOffice)
//                .courierId(courier)
//                .dateOfReceipt(pac.getDateOfReceipt())
//                .dateOfIssue(pac.getDateOfIssue())
//                .build();