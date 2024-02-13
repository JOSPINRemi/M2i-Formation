package org.example.demo_pathrequest.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Rabbit {
    private UUID id;
    private String name;
    private String breed;
}
