package com.jpa.onetoone.service;

import com.jpa.onetoone.dto.PassportDto;
import com.jpa.onetoone.dto.PersonDto;

import java.util.List;

public interface PersonService {

    List<PersonDto> getAllPersons();
    PersonDto createPerson(PersonDto personDto);
    PersonDto updatePerson(Long personId, PersonDto personDto);
    void deletePerson(Long personId);
    PassportDto getPassportByPersonId(Long personId);
    PassportDto createPassportForPerson(Long personId, PassportDto passportDto);
    void deletePassportByPersonId(Long personId);

}
