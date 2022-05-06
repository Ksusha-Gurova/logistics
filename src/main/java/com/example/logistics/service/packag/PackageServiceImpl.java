package com.example.logistics.service.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
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

@RequiredArgsConstructor
@Service
public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final ClientRepository clientRepository;
    private final OfficeRepository officeRepository;
    private final CourierRepository courierRepository;
    private final PackageMapper mapper;


    @Override
    public List<Package> findAll() {
        return packageRepository.findAll();
    }

    @Override
    public Package findPackage(Long id) {
        Optional<Package> optionalPackage = packageRepository.findById(id);
        return optionalPackage.orElse(null);
    }

    @Override
    public Package updatePackage(PackageRequestDto pacDto) {
        Package pac = packageRepository.findById(pacDto.getId()).orElse(null);

//        Package aPackage1 = packageRepository.findById(pacDto.getId())
//                .map(aPackage -> {
//                    //найти все связынные сущьности (клиент и тд)
//                    mapper.updateEntityFromDto(передать все аргументы)
//                })
//                .orElse(saveNewPackage(pacDto));

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
            return packageRepository.save(mapper.updateEntityFromDto(
                    pac,
                    pacDto,
                    toOffice, fromOffice,
                    toClient, fromClient,
                    courier));
        } else return saveNewPackage(pacDto);

    }

    @Override
    public Package saveNewPackage(PackageRequestDto pacDto) {
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

        return packageRepository.save(mapper.mapDtoToEntity(
                pacDto,
                toOffice, fromOffice,
                toClient, fromClient,
                courier));
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}