package com.jpa.onetoone.mapper;

import com.jpa.onetoone.dto.PassportDto;
import com.jpa.onetoone.model.Passport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    PassportDto toDto(Passport passport);

    Passport toEntity(PassportDto passportDto);
}