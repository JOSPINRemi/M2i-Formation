package org.example.demo_r2dbc.repository;

import org.example.demo_r2dbc.entity.Address;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AddressRepository extends R2dbcRepository<Address, Long> {

    @Query(
            "SELECT a.id, a.full_address, p.id, p.last_name, p.first_name " +
                    "FROM Address As a " +
                    "INNER JOIN Person as p " +
                    "ON a.person_id = p.id " +
                    "WHERE a.id = :id")
    Mono<Address> findAddressByIdWithPerson(long id);
}
