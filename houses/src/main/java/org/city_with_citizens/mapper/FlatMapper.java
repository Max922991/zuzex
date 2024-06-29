package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.FlatDto;
import org.city_with_citizens.entity.Flat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface FlatMapper {

    Flat toFlat(FlatDto flatDto);

    FlatDto toFlatDto(Flat flat);

}
