package com.example.logistics.mappers.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.entity.Client;
import com.example.logistics.entity.Courier;
import com.example.logistics.entity.Office;
import com.example.logistics.entity.Package;

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
}
