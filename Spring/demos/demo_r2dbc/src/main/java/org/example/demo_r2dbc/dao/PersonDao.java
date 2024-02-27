package org.example.demo_r2dbc.dao;


import io.r2dbc.spi.ConnectionFactory;
import org.example.demo_r2dbc.entity.Person;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonDao {

    private final ConnectionFactory connectionFactory;

    private DatabaseClient databaseClient;

    public PersonDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient
                .sql(
                        "CREATE TABLE IF NOT EXISTS Person(" +
                                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                "last_name varchar(100), " +
                                "first_name varchar(100)" +
                                ")"
                )
                .then()
                .doOnSuccess((Void) -> {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) -> {
                    System.out.println("Création de la table Not OK");
                });
        result.subscribe();
    }

    public Flux<Person> getAll() {
        return databaseClient
                .sql("SELECT * FROM Person")
                .fetch()
                .all()
                .map(m -> Person.builder()
                        .id(Integer.valueOf(m.get("id").toString()))
                        .lastName(m.get("last_name").toString())
                        .firstName(m.get("first_name").toString())
                        .build());
    }

    public Mono add(String lastName, String firstName) {
        Map<String, Object> values = new HashMap<>();
        values.put("lastname", lastName);
        values.put("firstname", firstName);
        Mono result = databaseClient.sql(
                        "INSERT INTO Person (last_name, first_name)" +
                                "VALUES (:lastname, :firstname)")
                /*.bind("lastname", lastName)
                .bind("firstname", firstName)*/
                .bindValues(values)
                .then();
        return result;
    }

    public Mono<Long> update(int id, String lastName, String firstName) {
        Map<String, Object> values = new HashMap<>();
        values.put("lastname", lastName);
        values.put("firstname", firstName);
        values.put("id", id);
        return databaseClient.sql(
                        "UPDATE Person " +
                                "SET last_name = :lastname, " +
                                "first_name = :firstname " +
                                "WHERE id = :id"
                )
                .bindValues(values)
//                .then()
                .fetch()
                .rowsUpdated();
    }

    public Mono delete(int id) {
        return databaseClient
                .sql(
                        "DELETE FROM Person " +
                                "WHERE id = :id"
                )
                .bind("id", id)
                .then();
    }
}
