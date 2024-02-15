package org.example.demo_validation.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.demo_validation.validation.MyValid;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @NotNull(message = "On a dit pas nul !!")
    @NotBlank
    @MyValid(value = "za",message = "On avait dit za !!")
    private String firstName;

    @NotNull
    @Size(min = 3, message = "3 minimum svp")
    private String lastName;

    @NotNull
    @Min(3)
    @Max(42)
    private Integer age;
}
