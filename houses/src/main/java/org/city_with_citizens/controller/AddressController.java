package org.city_with_citizens.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.AddressDto;
import org.city_with_citizens.mapper.AddressMapper;
import org.city_with_citizens.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class AddressController {

    private final AddressService houseService;
    private final AddressMapper houseMapper;

    @PostMapping
    public AddressDto create(@RequestBody AddressDto houseDto) {
        return houseMapper.toAddressDto(
                    houseService.create(
                            houseMapper.toAddress(houseDto)
                    )
        );
    }

    @GetMapping("/address/{addressId}")
    public AddressDto getById(@PathVariable UUID addressId) {
        return houseMapper.toAddressDto(
                houseService.getById(addressId)
        );
    }

    @PutMapping
    public AddressDto update(@RequestBody AddressDto houseDto) {
        return houseMapper.toAddressDto(
                    houseService.update(
                            houseMapper.toAddress(houseDto)
                    )
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{addressId}")
    public void delete(@PathVariable UUID addressId) {
        houseService.delete(addressId);
    }

}
