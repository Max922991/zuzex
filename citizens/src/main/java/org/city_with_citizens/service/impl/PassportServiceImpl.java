package org.city_with_citizens.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.client.HousesClient;
import org.city_with_citizens.entity.Citizen;
import org.city_with_citizens.entity.Passport;
import org.city_with_citizens.repository.PassportRepository;
import org.city_with_citizens.service.PassportService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final HousesClient housesClient;

    @Override
    public Passport create(Citizen citizen) {
        var random = new Random();

        var passport = new Passport();
        passport.setCitizen(citizen);
        passport.setSeries(
                String.valueOf(random.nextInt(9000) + 1000)
        );
        passport.setNumber(
                String.valueOf(random.nextInt(900000) + 100000)
        );

        return passportRepository.save(passport);
    }

    @Override
    public void delete(Citizen citizen) {
        var passport = passportRepository.findPassportByCitizenId(citizen.getId());
        passportRepository.delete(passport);
    }

    @Override
    public Passport update(Passport passport) {
        isCorrect(passport);
        var persistedPassport = passportRepository.findById(passport.getId()).orElseThrow(() ->
                new NoSuchElementException("Паспорта с запрашиваемым id не существует"));
        persistedPassport.setAddressFlatId(passport.getAddressFlatId());
        passportRepository.save(persistedPassport);
        return persistedPassport;
    }

    private void isCorrect(Passport passport) {
        if (passport.getAddressFlatId() != null) {
            try {
                housesClient.getFlatById(passport.getAddressFlatId());
            } catch (Exception e) {
                throw new NoSuchElementException("Указанной квартиры не существует или не удалось удостовериться в ее существовании");
            }
        }
    }

}
