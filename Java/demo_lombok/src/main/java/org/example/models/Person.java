package org.example.models;

import lombok.*;

@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    @Getter
    @Setter
    @NonNull
    private int id;

    @Setter
    @EqualsAndHashCode.Include
    private String firstname;

    @Setter
    @EqualsAndHashCode.Include
    private String lastname;
}
