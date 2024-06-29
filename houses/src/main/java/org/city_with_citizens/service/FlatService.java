package org.city_with_citizens.service;

import org.city_with_citizens.entity.Flat;

import java.util.UUID;

public interface FlatService {

    Flat create(Flat flat);

    Flat getById(UUID flatId);

    Flat update(Flat flat);

    void delete(UUID flatId);

}
