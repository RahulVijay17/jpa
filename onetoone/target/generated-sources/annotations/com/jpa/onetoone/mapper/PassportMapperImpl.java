package com.jpa.onetoone.mapper;

import com.jpa.onetoone.dto.PassportDto;
import com.jpa.onetoone.model.Passport;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T00:18:52+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class PassportMapperImpl implements PassportMapper {

    @Override
    public PassportDto toDto(Passport passport) {
        if ( passport == null ) {
            return null;
        }

        PassportDto passportDto = new PassportDto();

        passportDto.setId( passport.getId() );
        passportDto.setNumber( passport.getNumber() );
        passportDto.setExpirationDate( passport.getExpirationDate() );

        return passportDto;
    }

    @Override
    public Passport toEntity(PassportDto passportDto) {
        if ( passportDto == null ) {
            return null;
        }

        Passport passport = new Passport();

        passport.setId( passportDto.getId() );
        passport.setNumber( passportDto.getNumber() );
        passport.setExpirationDate( passportDto.getExpirationDate() );

        return passport;
    }
}
