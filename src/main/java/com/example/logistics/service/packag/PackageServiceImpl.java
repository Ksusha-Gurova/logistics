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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
        log.info("findAll()");
        return packageRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public PackageResponseDto findPackage(Long id) {
        log.info("findPackage(), id = {}", id);
        Optional<Package> optionalPackage = packageRepository.findById(id);
        return optionalPackage.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public PackageResponseDto saveOrUpdatePackage(PackageRequestDto dto) {
        log.info("saveOrUpdatePackage(), dto = {}", dto);

        Optional.ofNullable(dto.getId())
                .map(packageId -> packageRepository.findById(packageId)
                        .orElseThrow(() -> new EntityNotFoundException("Нет такой посылки в базе с id = " + packageId)));
        Client toClient = Optional.ofNullable(dto.getToClientId()).map(clientRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого клиента в базе с id = " + dto.getToClientId()));
        log.info("saveOrUpdatePackage(), загружены данные из базы, toClient = {}", toClient);

        Client fromClient = Optional.ofNullable(dto.getFromClientId()).map(clientRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого клиента в базе с id = " + dto.getToClientId()));
        log.info("saveOrUpdatePackage(), загружены данные из базы,");

        Office toOffice = Optional.ofNullable(dto.getToOfficeId()).map(officeRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого офиса в базе с id = " + dto.getToOfficeId()));
        log.info("saveOrUpdatePackage(), загружены данные из базы, fromClient = {}", fromClient);

        Office fromOffice = Optional.ofNullable(dto.getFromOfficeId()).map(officeRepository::getById)
                .orElseThrow(() -> new EntityNotFoundException("Нет такого офиса в базе с id = " + dto.getFromOfficeId()));
        log.info("saveOrUpdatePackage(), загружены данные из базы, fromOffice = {}", fromOffice);

        Courier courier = Optional.ofNullable(dto.getCourierId()).map(courierRepository::getById)
                .orElse(null);
        log.info("saveOrUpdatePackage(), загружены данные из базы, courier = {}", courier);

        Package pack = Optional.ofNullable(dto.getId())
                .map(packageId -> {
                    Package entityFromDataBase = packageRepository.getById(packageId);
                    return mapper.updateEntityFromDto(entityFromDataBase, dto, toOffice, fromOffice, toClient, fromClient, courier);
                })
                .orElse(mapper.mapDtoToEntity(dto, toOffice, fromOffice, toClient, fromClient, courier));
        pack = packageRepository.save(pack);
        log.info("saveOrUpdatePackage(), сохранены данные в базу, pack = {}", pack);
        return mapper.mapEntityToDto(pack);
    }

    @Override
    public void deletePackage(Long id) {
        log.info("deletePackage(), id = {}", id);
        packageRepository.deleteById(id);
    }

    @Override
    public List<PackageResponseDto> findAllPackagesFromClient(Long id) {
        log.info("findAllPackagesFromClient(), id = {}", id);
        return packageRepository.findAllByFromClient_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());

    }

    @Override
    public List<PackageResponseDto> findAllPackagesToClient(Long id) {
        log.info("findAllPackagesFromClient(), id = {}", id);
        return packageRepository.findAllByToClient_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesFromOffice(Long id) {
        log.info("findPackagesFromOffice(), id = {}", id);
        return packageRepository.findAllByFromOffice_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesToOffice(Long id) {
        log.info("findPackagesToOffice(), id = {}", id);
        return packageRepository.findAllByToOffice_Id(id).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesByStatus(String status) {
        log.info("findPackagesByStatus(), status = {}", status);
        return packageRepository.findAllByStatus(Status.valueOf(status)).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<PackageResponseDto> findPackagesByCourier(Long courierID) {
        log.info("findPackagesByCourier(), courierID = {}", courierID);
        return packageRepository.findAllByCourier_Id(courierID).stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }
}
