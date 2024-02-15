package org.example.demo_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MyValidConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValid {
    public String value() default "to";

    public String message() default "Doit contenir to !!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
