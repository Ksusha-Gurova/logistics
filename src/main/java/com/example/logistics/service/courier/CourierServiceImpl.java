package com.example.logistics.service.courier;

import com.example.logistics.dto.courier.CourierRequestDto;
import com.example.logistics.dto.courier.CourierResponseDto;
import com.example.logistics.model.Courier;
import com.example.logistics.mappers.courier.CourierMapper;
import com.example.logistics.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper mapper;

    @Override
    public List<CourierResponseDto> findAll() {
        return courierRepository.findAll().stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public CourierResponseDto findCourier(Long id) {
        Optional<Courier> optionalCourier = courierRepository.findById(id);
        return optionalCourier.map(mapper::mapEntityToDto).orElse(null);
    }

    @Override
    public CourierResponseDto updateCourier(CourierRequestDto dto) {
        Courier courier = courierRepository.findById(dto.getId()).orElse(null);
        if (courier != null){
            Courier updatedCourier = courierRepository.save(mapper.updateEntityFromDto(dto, courier));
            return mapper.mapEntityToDto(updatedCourier);
        } else return saveNewCourier(dto);
    }

    @Override
    public CourierResponseDto saveNewCourier(CourierRequestDto dto) {
        Courier newCourier = courierRepository.save(mapper.mapDtoToEntity(dto));
        return mapper.mapEntityToDto(newCourier);
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
