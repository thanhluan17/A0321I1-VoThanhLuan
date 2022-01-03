package com.codegym.furama.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class DoBValidate implements ConstraintValidator<Birthday, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean check = true;
        if (value.equals("") || value == null)
            value = "2022-01-01";
        LocalDate birthday;
        if (check) {
            String[] dateString = value.split("-");
            int date = Integer.parseInt(dateString[2]);
            int month = Integer.parseInt(dateString[1]);
            int year = Integer.parseInt(dateString[0]);
            try {
                birthday = LocalDate.of(year, month, date);
            } catch (Exception e) {
                throw e;
            }
            LocalDate today = LocalDate.now();
            if (Period.between(birthday, today).getYears() < 18 || year < 1900) {
                check = false;
            }
        } else {
            check = false;
        }
        return check;
    }
}
