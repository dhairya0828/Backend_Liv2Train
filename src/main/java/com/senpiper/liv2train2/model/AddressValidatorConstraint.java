package com.senpiper.liv2train2.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AddressValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AddressValidatorConstraint {
    String message() default "Address fields can not be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
