package com.jpa.onetoone.service;

import com.jpa.onetoone.dto.PassportDto;
import com.jpa.onetoone.dto.PersonDto;
import com.jpa.onetoone.mapper.PassportMapper;
import com.jpa.onetoone.mapper.PersonMapper;
import com.jpa.onetoone.model.Passport;
import com.jpa.onetoone.model.Person;
import com.jpa.onetoone.repository.PassportRepository;
import com.jpa.onetoone.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PassportRepository passportRepository;
    private final PersonMapper personMapper;
    private final PassportMapper passportMapper;


    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return personMapper.toDtoList(persons);
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        Person savedPerson = personRepository.save(person);
        return personMapper.toDto(savedPerson);
    }
    @Override
    public PersonDto updatePerson(Long personId, PersonDto personDto) {
        Person existingPerson = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personId));
        personMapper.updatePersonFromDto(personDto, existingPerson);
        Person updatedPerson = personRepository.save(existingPerson);
        return personMapper.toDto(updatedPerson);
    }
    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public PassportDto getPassportByPersonId(Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personId));
        Passport passport = person.getPassport();
        return passportMapper.toDto(passport);
    }

    @Override
    public PassportDto createPassportForPerson(Long personId, PassportDto passportDto) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personId));
        Passport passport = passportMapper.toEntity(passportDto);
        person.setPassport(passport);
        Passport savedPassport = passportRepository.save(passport);
        return passportMapper.toDto(savedPassport);
    }

    @Override
    public void deletePassportByPersonId(Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + personId));
        Passport passport = person.getPassport();
        if (passport != null) {
            person.setPassport(null);
            passportRepository.deleteById(passport.getId());
        }
    }
}
