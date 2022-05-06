package com.example.logistics.mappers.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.dto.packag.PackageResponseDto;
import com.example.logistics.model.Client;
import com.example.logistics.model.Courier;
import com.example.logistics.model.Office;
import com.example.logistics.model.Package;

public interface PackageMapper {
    Package mapDtoToEntity(
            PackageRequestDto dto,
            Office toOffice,
            Office fromOffice,
            Client toClient,
            Client fromClient,
            Courier courier);

    Package updateEntityFromDto(
            Package pac,
            PackageRequestDto dto,
            Office toOffice,
            Office fromOffice,
            Client toClient,
            Client fromClient,
            Courier courier);

    PackageResponseDto mapEntityToDto(Package pac);
}
