package org.city_with_citizens.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.client.BankClient;
import org.city_with_citizens.entity.Citizen;
import org.city_with_citizens.exception.CitizenException;
import org.city_with_citizens.repository.CitizenRepository;
import org.city_with_citizens.repository.GenderRepository;
import org.city_with_citizens.service.CitizenService;
import org.city_with_citizens.service.PassportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;
    private final PassportService passportService;
    private final GenderRepository genderRepository;
    private final BankClient bankClient;

    @Override
    @Transactional
    public Citizen create(Citizen citizen) {
        isCorrect(citizen);
        citizenRepository.save(citizen);
        passportService.create(citizen);
        try {
            bankClient.create(citizen.getId());
        } catch (Exception e) {
            log.warn("Не удалось создать счет для пользователя с id " + citizen.getId());
        }
        return citizen;
    }

    @Override
    public Citizen getById(UUID citizenId) {
        return citizenRepository.findById(citizenId).orElseThrow(() ->
                new NoSuchElementException("Жителя с запрашиваемым id не существует"));
    }

    @Override
    public Citizen update(Citizen citizen) {
        isCorrect(citizen);
        return citizenRepository.save(citizen);
    }

    @Override
    @Transactional
    public void delete(UUID citizenId) {
        var citizen = citizenRepository.findById(citizenId).orElseThrow();
        passportService.delete(citizen);
        citizenRepository.delete(citizen);
        bankClient.delete(citizenId);
    }

    private void isCorrect(Citizen citizen) {
        if (citizen.getName() == null) {
            throw new CitizenException("Имя жителя не может быть пустым");
        }

        try {
            genderRepository.findById(citizen.getGender().getId()).orElseThrow(() ->
                    new CitizenException("Указанного пола не существует"));
        } catch (Exception e) {
            throw new CitizenException("Не удалось удостовериться в корректности выбранного пола");
        }

        LocalDate to = LocalDate.of(1950, Month.JANUARY, 1);
        LocalDate from = LocalDate.now();
        if (citizen.getBirthday().isAfter(from) || citizen.getBirthday().isBefore(to)) {
            throw new CitizenException("Невозможная дата рождения жителя");
        }
    }

}
