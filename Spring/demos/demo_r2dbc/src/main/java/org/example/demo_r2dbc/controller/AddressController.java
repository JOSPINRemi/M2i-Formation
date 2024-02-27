package org.example.demo_r2dbc.controller;

import org.example.demo_r2dbc.entity.Address;
import org.example.demo_r2dbc.repository.AddressRepository;
import org.example.demo_r2dbc.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressRepository addressRepository;

    private final PersonRepository personRepository;

    public AddressController(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    @PostMapping
    public Mono<Address> post(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("{id}")
    public Mono<Address> get(@PathVariable long id) {
        return addressRepository.findById(id).flatMap(address ->
                personRepository.findById(address.getPersonId())
                        .map(person -> {
                            address.setPerson(person);
                            return address;
                        })
        );
    }

    @GetMapping("second/{id}")
    public Mono<Address> secondGet(@PathVariable long id){
        return addressRepository.findAddressByIdWithPerson(id);
    }
}
