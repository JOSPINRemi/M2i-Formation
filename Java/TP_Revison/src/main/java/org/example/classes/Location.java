package org.example.classes;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
public class Location {
    @Setter
    private String name;

    @Setter
    private String address;

    @Setter
    private int capacity;
}
