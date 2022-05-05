package com.example.logistics.service.packag;

import com.example.logistics.dto.packag.PackageRequestDto;
import com.example.logistics.entity.*;
import com.example.logistics.entity.Package;
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
        List<Package> allPackages = packageRepository.findAll();
        return allPackages;
    }

    @Override
    public Package findPackage(Long id) {
        Optional<Package> optionalPackage = packageRepository.findById(id);
        return optionalPackage.get();
    }

    @Override
    public Package updatePackage(PackageRequestDto pacDto) {
        Package pac = packageRepository.getById(pacDto.getId());

        if (pac != null) {
            Client toClient = clientRepository.findById(pacDto.getToClientId()).get();
            Client fromClient = clientRepository.findById(pacDto.getFromClientId()).get();
            Office toOffice = officeRepository.findById(pacDto.getToOfficeId()).get();
            Office fromOffice = officeRepository.findById(pacDto.getFromOfficeId()).get();

            // В трех следующих строках происходи тоже, что и в методе saveNewPackage в блоке if().
            // Это альтернативный вариант
            Courier courier = Optional.ofNullable(pacDto.getCourierId())
                .map(courierId -> courierRepository.getById(courierId))
                .orElse(null);
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
        Client toClient = clientRepository.findById(pacDto.getToClientId()).get();
        Client fromClient = clientRepository.findById(pacDto.getFromClientId()).get();
        Office toOffice = officeRepository.findById(pacDto.getToOfficeId()).get();
        Office fromOffice = officeRepository.findById(pacDto.getFromOfficeId()).get();

        Courier courier = null;
        if (pacDto.getCourierId() != null) courier = courierRepository.getById(pacDto.getCourierId());

//        Courier courier1 = Optional.ofNullable(pacDto.getCourierId())
//                .map(courierId -> courierRepository.getById(courierId))
//                .orElse(null);


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