package org.city_with_citizens.autoshop.service;

import org.city_with_citizens.autoshop.entity.Color;

import java.util.UUID;

public interface ColorService {

    Color create(Color color);

    Color getById(UUID colorId);

    Color update(Color color);

    void delete(UUID colorId);

}
