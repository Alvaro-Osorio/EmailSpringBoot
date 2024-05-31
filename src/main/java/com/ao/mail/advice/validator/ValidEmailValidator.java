package com.ao.mail.advice.validator;


import com.ao.mail.advice.anotation.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        //Value cannot be null
        if (value== null){
            return false;
        }
        if (value.isEmpty()){
            return false;
        }
        if (value.isBlank()){
            return false;
        }
        if (!validate(value)){
            return false;
        }

        return true;
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_REGEX.matcher(emailStr);
        return matcher.matches();
    }

}
