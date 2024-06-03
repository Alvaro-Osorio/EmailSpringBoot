package com.ao.mail.advice.validation.anotation;

import com.ao.mail.advice.validation.validator.ValidEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidEmail {

    String message() default "{custom.validation.messages}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
