package org.city_with_citizens.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.CitizenDto;
import org.city_with_citizens.mapper.CitizenMapper;
import org.city_with_citizens.service.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;
    private final CitizenMapper citizenMapper;

    @PostMapping
    public CitizenDto createCitizen(@RequestBody CitizenDto citizenDto) {
        return citizenMapper.toCitizenDto(
                citizenService.create(
                        citizenMapper.toCitizen(citizenDto)
                )
        );
    }

    @GetMapping("/citizen/{citizenId}")
    public CitizenDto getById(@PathVariable UUID citizenId) {
        return citizenMapper.toCitizenDto(
                citizenService.getById(citizenId)
        );
    }

    @PutMapping
    public CitizenDto update(@RequestBody CitizenDto citizenDto) {
        return citizenMapper.toCitizenDto(
                citizenService.update(
                        citizenMapper.toCitizen(citizenDto)
                )
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{citizenId}")
    public void delete(@PathVariable UUID citizenId) {
        citizenService.delete(citizenId);
    }

}