package com.metro.homework.ecommerce.service.mapper;

import com.metro.homework.ecommerce.api.dto.AddressDTO;
import com.metro.homework.ecommerce.domain.entity.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    AddressDTO toDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setPhone(address.getPhone());
        return addressDTO;
    }

}
