package com.codegym.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DoBValidate.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Birthday {
    String message() default "Customer's age must be more than 18";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
