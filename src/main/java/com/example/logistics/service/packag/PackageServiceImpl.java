package com.example.logistics.service.packag;

import com.example.logistics.api.dto.request.PackageRequestDto;
import com.example.logistics.api.dto.response.PackageResponseDto;
import com.example.logistics.model.*;
import com.example.logistics.model.Package;
import com.example.logistics.mappers.PackageMapper;
import com.example.logistics.repository.ClientRepository;
import com.example.logistics.repository.CourierRepository;
import com.example.logistics.repository.OfficeRepository;
import com.example.logistics.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final ClientRepository clientRepository;
    private final OfficeRepository officeRepository;
    private final CourierRepository courierRepository;
    private final PackageMapper mapper;


    @Override
    public List<PackageResponseDto> findAll() {
        return packageRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public PackageResponseDto findPackage(Long id) {
        Optional<Package> optionalPackage = packageRepository.findById(id);
        return optionalPackage.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public PackageResponseDto saveOrUpdatePackage(PackageRequestDto dto) {

        Optional.ofNullable(dto.getId())
                .map(packageId -> packageRepository.findById(packageId)
                        .orElseThrow(() -> new EntityNotFoundException("Нет такой посылки в базе с id = " + packageId)));
        Client toClient = Optional.ofNullable(dto.getToClientId()).map(clientRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого клиента в базе с id = " + dto.getToClientId()));
        Client fromClient = Optional.ofNullable(dto.getFromClientId()).map(clientRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого клиента в базе с id = " + dto.getToClientId()));
        Office toOffice = Optional.ofNullable(dto.getToOfficeId()).map(officeRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого офиса в базе с id = " + dto.getToOfficeId()));
        Office fromOffice = Optional.ofNullable(dto.getFromOfficeId()).map(officeRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого офиса в базе с id = " + dto.getFromOfficeId()));
        Courier courier = Optional.ofNullable(dto.getCourierId()).map(courierRepository::getById)
                .orElse(null);

        Package pack = Optional.ofNullable(dto.getId())
                .map(packageId -> {
                    Package entityFromDataBase = packageRepository.getById(packageId);
                    return mapper.updateEntityFromDto(entityFromDataBase, dto, toOffice, fromOffice, toClient, fromClient, courier);
                })
                .orElse(mapper.mapDtoToEntity(dto, toOffice, fromOffice, toClient, fromClient, courier));
        pack = packageRepository.save(pack);
        return mapper.mapEntityToDto(pack);
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }

    @Override
    public List<PackageResponseDto> findAllPackagesFromClient(Long id) {
        return packageRepository.findAllByFromClient_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());

    }

    @Override
    public List<PackageResponseDto> findAllPackagesToClient(Long id) {
        return packageRepository.findAllByToClient_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesFromOffice(Long id) {
        return packageRepository.findAllByFromOffice_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesToOffice(Long id) {
        return packageRepository.findAllByToOffice_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesByStatus(String status) {
        return packageRepository.findAllByStatus(Status.valueOf(status)).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesByCourier(Long courierID) {
        return packageRepository.findAllByCourier_Id(courierID).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }
}
