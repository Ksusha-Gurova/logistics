package com.example.logistics.service.courier;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.entity.Courier;
import com.example.logistics.mappers.courier.CourierMapper;
import com.example.logistics.repository.CourierRepository;
import com.example.logistics.service.courier.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper mapper;

    @Override
    public List<Courier> findAll() {
        List<Courier> allCourier = courierRepository.findAll();
        return allCourier;
    }

    @Override
    public Courier findCourier(Long id) {
        Optional<Courier> optionalCourier = courierRepository.findById(id);
        return optionalCourier.get();
    }

    @Override
    public Courier updateCourier(CourierRequestDto dto) {
        Courier courier = courierRepository.getById(dto.getId());
        if (courier != null){
            return courierRepository.save(mapper.updateEntityFromDto(dto, courier));
        } else return saveNewCourier(dto);
    }

    @Override
    public Courier saveNewCourier(CourierRequestDto dto) {
        return courierRepository.save(mapper.mapDtoToEntity(dto));
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
