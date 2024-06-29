package org.city_with_citizens.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.entity.Flat;
import org.city_with_citizens.repository.FlatRepository;
import org.city_with_citizens.service.FlatService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlatServiceImpl implements FlatService {

    private FlatRepository flatRepository;

    @Override
    public Flat create(Flat flat) {
        return flatRepository.save(flat);
    }

    @Override
    public Flat getById(UUID flatId) {
        return flatRepository.findById(flatId).orElseThrow(() ->
            new NoSuchElementException("Квартиры с указанным id не существует")
        );
    }

    @Override
    public Flat update(Flat flat) {
        return flatRepository.save(flat);
    }

    @Override
    public void delete(UUID flatId) {
        flatRepository.deleteById(flatId);
    }
}
