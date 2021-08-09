package com.scb.pmkdif.api.validator.aa05;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(validatedBy = Valid05Validator.class)
@Target({FIELD,TYPE})
@Retention(RUNTIME)
public @interface Valid05Calculation {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
