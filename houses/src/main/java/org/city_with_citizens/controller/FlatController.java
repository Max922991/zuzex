package org.city_with_citizens.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.FlatDto;
import org.city_with_citizens.mapper.FlatMapper;
import org.city_with_citizens.service.FlatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class FlatController {

    private final FlatMapper flatMapper;
    private final FlatService flatService;

    @PostMapping("/flat")
    public FlatDto create(@RequestBody FlatDto flatDto) {
        return flatMapper.toFlatDto(
                    flatService.create(
                            flatMapper.toFlat(flatDto)
                    )
        );
    }

    @GetMapping("/flat/{flatId}")
    public FlatDto getById(@PathVariable UUID flatId) {
        return flatMapper.toFlatDto(
                    flatService.getById(flatId)
        );
    }

    @PutMapping("/flat")
    public FlatDto update(@RequestBody FlatDto flatDto) {
        return flatMapper.toFlatDto(
                    flatService.update(
                            flatMapper.toFlat(flatDto)
                    )
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/flat/delete/{flatId}")
    public void delete(@PathVariable UUID flatId) {
        flatService.delete(flatId);
    }

}
