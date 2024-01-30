package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private int rentDueIn;
    private int condition;
    private boolean luxury;
    private boolean old;
}
