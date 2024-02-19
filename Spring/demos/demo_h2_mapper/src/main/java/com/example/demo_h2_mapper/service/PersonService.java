package com.example.demo_h2_mapper.service;

import com.example.demo_h2_mapper.mapper.PersonMapper;
import com.example.demo_h2_mapper.model.PersonDTO;
import com.example.demo_h2_mapper.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> listPersons() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::personToPersonDto)
                .toList();
    }

    public PersonDTO addPerson(PersonDTO personDTO) {
        /*Person person = personMapper.personDtoToPerson(personDTO);
        Person savedPerson = personRepository.save(person);
        PersonDTO savedPersonDto = personMapper.personToPersonDto(savedPerson);
        return savedPersonDto;*/

        return personMapper.personToPersonDto(personRepository.save(personMapper.personDtoToPerson(personDTO)));
    }
}
