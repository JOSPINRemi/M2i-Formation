package com.example.demo_h2_mapper.mapper;

import com.example.demo_h2_mapper.entities.Person;
import com.example.demo_h2_mapper.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "firstName", target = "blabla")
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    PersonDTO personToPersonDto(Person person);

    @Mapping(source = "blabla", target = "firstName")
    Person personDtoToPerson(PersonDTO personDTO);

    @Named("convertDateToAge")
    public static Integer convertDateToAge(LocalDate date){
        LocalDate now = LocalDate.now();
        int age = now.getYear() - date.getYear();
        if (now.minusYears(age).isBefore(date)){
            age--;
        }
        return age;
    }
}
