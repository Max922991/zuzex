package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.CitizenDto;
import org.city_with_citizens.entity.Citizen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GenderMapper.class})
public interface CitizenMapper {

    CitizenDto toCitizenDto(Citizen citizen);

    Citizen toCitizen(CitizenDto citizenDto);

}
