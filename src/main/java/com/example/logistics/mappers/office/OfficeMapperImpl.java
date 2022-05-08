package com.example.logistics.mappers.office;

import com.example.logistics.api.dto.office.OfficeRequestDto;
import com.example.logistics.api.dto.office.OfficeResponseDto;
import com.example.logistics.model.City;
import com.example.logistics.model.Office;
import org.springframework.stereotype.Component;

@Component
public class OfficeMapperImpl implements OfficeMapper{


    @Override
    public Office mapDtoToEntity(OfficeRequestDto dto) {
        return Office.builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .city(City.valueOf(dto.getCity()))
                .phone(dto.getPhone())
                .build();
    }

    @Override
    public Office updateEntityFromDto(OfficeRequestDto dto, Office office) {
        office.setAddress(dto.getAddress());
        office.setCity(City.valueOf(dto.getCity()));
        office.setPhone(dto.getPhone());
        return office;
    }

    @Override
    public OfficeResponseDto mapEntityToDto(Office office) {
        return OfficeResponseDto.builder()
                .id(office.getId())
                .address(office.getAddress())
                .city(office.getCity().getTranslation())
                .phone(office.getPhone())
                .build();
    }
}
