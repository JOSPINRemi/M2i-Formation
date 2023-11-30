package org.example.classes;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lieu {
    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String adresse;

    @Getter
    @Setter
    private int capacite;
}
