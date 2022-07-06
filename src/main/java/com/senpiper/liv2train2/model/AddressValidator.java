package com.senpiper.liv2train2.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<AddressValidatorConstraint, AddressDetails> {
    @Override
    public void initialize(AddressValidatorConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final AddressDetails addressDetails,
                           final ConstraintValidatorContext constraintValidatorContext) {

        if(addressDetails == null)
            return false;

        if(addressDetails.getDetailedAddress() == null || addressDetails.getDetailedAddress().isBlank()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Detailed Address field should not be empty").addConstraintViolation();
            return false;
        }

        if(addressDetails.getCity() == null || addressDetails.getCity().isBlank()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("City field should not be empty").addConstraintViolation();
            return false;
        }

        if(addressDetails.getState() == null || addressDetails.getState().isBlank()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("State field should not be empty").addConstraintViolation();
            return false;
        }

        if(addressDetails.getPincode() == null || addressDetails.getPincode().isBlank()){
            constraintValidatorContext.buildConstraintViolationWithTemplate(" Pin code field should not be empty").addConstraintViolation();
            return false;
        }

        return true;
    }

}
