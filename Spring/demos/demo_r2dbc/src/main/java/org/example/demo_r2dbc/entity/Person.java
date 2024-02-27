package org.example.demo_r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Person {

    @Id
    private int id;

    private String lastName;

    private String firstName;

}
