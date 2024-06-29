package org.city_with_citizens.service;

import org.city_with_citizens.entity.Citizen;

import java.util.UUID;

public interface CitizenService {

    Citizen create(Citizen citizen);

    Citizen getById(UUID citizenId);

    Citizen update(Citizen citizen);

    void delete(UUID citizenId);

}
