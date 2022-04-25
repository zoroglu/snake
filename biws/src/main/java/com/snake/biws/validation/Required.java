package com.snake.biws.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { RequiredValidator.class})
public @interface Required {

	String message() default "Cannot be empty";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
