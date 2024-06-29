package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.GenderDto;
import org.city_with_citizens.entity.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    Gender toGender(GenderDto genderDto);

    GenderDto toGenderDto(Gender gender);

}
