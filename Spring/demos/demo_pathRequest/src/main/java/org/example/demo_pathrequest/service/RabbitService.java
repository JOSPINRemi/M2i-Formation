package org.example.demo_pathrequest.service;

import org.example.demo_pathrequest.model.Rabbit;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RabbitService {
    private final Map<UUID, Rabbit> rabbits;

    public RabbitService() {
        this.rabbits = new HashMap<>();

        Rabbit rabbitA = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Bugs Bunny")
                .breed("angora")
                .build();

        Rabbit rabbitB = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Lola Bunny")
                .breed("bélier")
                .build();

        Rabbit rabbitC = Rabbit.builder()
                .id(UUID.randomUUID())
                .name("Roger Rabbit")
                .breed("Jersey Wooly")
                .build();

        rabbits.put(rabbitA.getId(), rabbitA);
        rabbits.put(rabbitB.getId(), rabbitB);
        rabbits.put(rabbitC.getId(), rabbitC);
    }

    public List<Rabbit> getRabbits() {
        return rabbits.values().stream().toList();
    }

    public Rabbit getRabbitById(UUID id) {
        /*return rabbits.values()
                .stream()
                .filter(
                        rabbit -> rabbit.getId().equals(id)
                )
                .findFirst()
                .orElse(null);*/
        return rabbits.get(id);
    }
}
