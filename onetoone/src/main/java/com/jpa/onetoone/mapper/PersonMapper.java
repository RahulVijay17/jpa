package com.jpa.onetoone.mapper;

import com.jpa.onetoone.dto.PersonDto;
import com.jpa.onetoone.model.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PassportMapper.class})
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto toDto(Person person);

    Person toEntity(PersonDto personDto);

    List<PersonDto> toDtoList(List<Person> persons);

    void updatePersonFromDto(PersonDto personDto, @MappingTarget Person person);
}