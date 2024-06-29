package org.city_with_citizens.service;

import org.city_with_citizens.entity.Citizen;
import org.city_with_citizens.entity.Passport;

public interface PassportService {

    Passport create(Citizen citizen);

    void delete(Citizen citizen);

    Passport update(Passport passport);

}
