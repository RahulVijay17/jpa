package com.jpa.onetoone.controller;

import com.jpa.onetoone.dto.PassportDto;
import com.jpa.onetoone.dto.PersonDto;
import com.jpa.onetoone.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;


    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable("id") Long personId, @RequestBody PersonDto personDto) {
        return personService.updatePerson(personId, personDto);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long personId) {
        personService.deletePerson(personId);
    }

    @GetMapping("/{id}/passport")
    public PassportDto getPassportByPersonId(@PathVariable("id") Long personId) {
        return personService.getPassportByPersonId(personId);
    }

    @PostMapping("/{id}/passport")
    public ResponseEntity<PassportDto> createPassportForPerson(@PathVariable("id") Long personId,
                                                               @RequestBody PassportDto passportDto) {
        PassportDto createdPassport = personService.createPassportForPerson(personId, passportDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPassport);
    }

    @DeleteMapping("/{id}/passport")
    public ResponseEntity<?> deletePassportByPersonId(@PathVariable("id") Long personId) {
        personService.deletePassportByPersonId(personId);
        return ResponseEntity.noContent().build();
    }
}