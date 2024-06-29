package org.city_with_citizens.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.PassportDto;
import org.city_with_citizens.mapper.PassportMapper;
import org.city_with_citizens.service.PassportService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PassportController {

    private final PassportService passportService;
    private final PassportMapper passportMapper;

    @PutMapping("/passport")
    public PassportDto update(@RequestBody PassportDto passportDto) {
        return passportMapper.toPassportDto(
                passportService.update(
                        passportMapper.toPassport(passportDto)
                )
        );
    }

}
