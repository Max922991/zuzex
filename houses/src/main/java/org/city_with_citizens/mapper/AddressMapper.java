package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.AddressDto;
import org.city_with_citizens.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressDto houseDto);

    AddressDto toAddressDto(Address house);

}
