package org.city_with_citizens.autoshop.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.autoshop.entity.Color;
import org.city_with_citizens.autoshop.repository.ColorRepository;
import org.city_with_citizens.autoshop.service.ColorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    @Override
    public Color create(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color getById(UUID colorId) {
        return colorRepository.findById(colorId).orElseThrow(()->
                new NoSuchElementException("Цвета машины с указанным id не существует"));
    }

    @Override
    public Color update(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void delete(UUID colorId) {
        colorRepository.deleteById(colorId);
    }
}
