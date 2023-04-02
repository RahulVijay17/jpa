package com.jpa.onetoone.mapper;

import com.jpa.onetoone.dto.PersonDto;
import com.jpa.onetoone.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T00:18:52+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Autowired
    private PassportMapper passportMapper;

    @Override
    public PersonDto toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( person.getId() );
        personDto.setName( person.getName() );
        personDto.setEmail( person.getEmail() );
        personDto.setPassport( passportMapper.toDto( person.getPassport() ) );

        return personDto;
    }

    @Override
    public Person toEntity(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDto.getId() );
        person.setName( personDto.getName() );
        person.setEmail( personDto.getEmail() );
        person.setPassport( passportMapper.toEntity( personDto.getPassport() ) );

        return person;
    }

    @Override
    public List<PersonDto> toDtoList(List<Person> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( persons.size() );
        for ( Person person : persons ) {
            list.add( toDto( person ) );
        }

        return list;
    }

    @Override
    public void updatePersonFromDto(PersonDto personDto, Person person) {
        if ( personDto == null ) {
            return;
        }

        person.setId( personDto.getId() );
        person.setName( personDto.getName() );
        person.setEmail( personDto.getEmail() );
        person.setPassport( passportMapper.toEntity( personDto.getPassport() ) );
    }
}
