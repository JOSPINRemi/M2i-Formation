package com.example.candy_shop_exercise.validator;

import com.example.candy_shop_exercise.entity.CandyOrder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("afterCreateCandyOrderValidator")
public class CandyOrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CandyOrder.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("Mail de création envoyé");
    }
}
