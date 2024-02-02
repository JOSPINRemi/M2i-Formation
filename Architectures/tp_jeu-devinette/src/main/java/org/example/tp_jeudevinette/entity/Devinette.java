package org.example.tp_jeudevinette.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "devinette")
public class Devinette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String reponse;

    @OneToMany(mappedBy = "devinette")
    private List<Proposition> propositions = new ArrayList<>();
}