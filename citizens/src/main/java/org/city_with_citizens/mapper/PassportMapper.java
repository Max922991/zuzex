package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.PassportDto;
import org.city_with_citizens.entity.Passport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport toPassport(PassportDto passportDto);

    PassportDto toPassportDto(Passport passport);

}
