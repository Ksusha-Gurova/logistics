package com.example.logistics.service.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.dto.packag.PackageResponseDto;
import com.example.logistics.model.*;
import com.example.logistics.model.Package;
import com.example.logistics.mappers.packag.PackageMapper;
import com.example.logistics.repository.ClientRepository;
import com.example.logistics.repository.CourierRepository;
import com.example.logistics.repository.OfficeRepository;
import com.example.logistics.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public PackageResponseDto updatePackage(PackageRequestDto pacDto) {
        Package pac = packageRepository.findById(pacDto.getId()).orElse(null);

        if (pac != null) {
            Client toClient = null;
            if (pacDto.getToClientId() != null) toClient = clientRepository.findById(pacDto.getToClientId()).orElse(null);

            Client fromClient = null;
            if (pacDto.getFromClientId() != null) fromClient = clientRepository.findById(pacDto.getFromClientId()).orElse(null);

            Office toOffice = null;
            if (pacDto.getToOfficeId() != null) toOffice = officeRepository.findById(pacDto.getToOfficeId()).orElse(null);

            Office fromOffice = null;
            if (pacDto.getFromOfficeId() != null)
               fromOffice = officeRepository.findById(pacDto.getFromOfficeId()).orElse(null);

            // В трех следующих строках происходи тоже, что и в методе saveNewPackage в блоке if() под курьером.
            // Это альтернативный вариант
            Courier courier = Optional.ofNullable(pacDto.getCourierId()).map(courierRepository::getById).orElse(null);
            Package updatedpackage = packageRepository.save(mapper.updateEntityFromDto(
                    pac,
                    pacDto,
                    toOffice, fromOffice,
                    toClient, fromClient,
                    courier));
            return mapper.mapEntityToDto(updatedpackage);
        } else return saveNewPackage(pacDto);

    }

    @Override
    public PackageResponseDto saveNewPackage(PackageRequestDto pacDto) {
        Client toClient = null;
        if (pacDto.getToClientId() != null) toClient = clientRepository.findById(pacDto.getToClientId()).orElse(null);

        Client fromClient = null;
        if (pacDto.getFromClientId() != null) fromClient = clientRepository.findById(pacDto.getFromClientId()).orElse(null);

        Office toOffice = null;
        if (pacDto.getToOfficeId() != null) toOffice = officeRepository.findById(pacDto.getToOfficeId()).orElse(null);

        Office fromOffice = null;
        if (pacDto.getFromOfficeId() != null) fromOffice = officeRepository.findById(pacDto.getFromOfficeId()).orElse(null);

        Courier courier = null;
        if (pacDto.getCourierId() != null) courier = courierRepository.findById(pacDto.getCourierId()).orElse(null);

        Package newPackage = packageRepository.save(mapper.mapDtoToEntity(
                pacDto,
                toOffice, fromOffice,
                toClient, fromClient,
                courier));
        return mapper.mapEntityToDto(newPackage);
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}