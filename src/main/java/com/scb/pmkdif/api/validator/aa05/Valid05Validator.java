package com.scb.pmkdif.api.validator.aa05;

import com.scb.pmkdif.api.model.ErrorCodes;
import com.scb.pmkdif.api.model.aa05.AA05Request;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Valid05Validator implements ConstraintValidator<Valid05Calculation, AA05Request> {

    @Override
    public boolean isValid(AA05Request value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (value == null) {
            context.buildConstraintViolationWithTemplate(ErrorCodes.AP00001.getMessage())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
