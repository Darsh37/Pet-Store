package com.petstoreapp.petapp.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


//This class will contain isValid method
//which is called when we apply @phone annotation on the field 

public class PhoneValidator implements ConstraintValidator<Phone, String> 
{

    @Override
    // Here value will get the input value of the phone
    //which we have to validate

    public boolean isValid(String value, ConstraintValidatorContext context) {
        //[0-9] indicates any digit
        //+ indicates more than 1 digit
        boolean condition = value.length() == 10  && value.matches("[0-9]+");
        return condition;
    }

    
}
