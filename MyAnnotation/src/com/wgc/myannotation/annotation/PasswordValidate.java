package com.wgc.myannotation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidate implements ConstraintValidator<Verification, String> {

    private String pwd;


    @Override
    public void initialize(Verification constraintAnnotation) {
        this.pwd = constraintAnnotation.pwd();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        } else if (s.matches(pwd)) {
            return true;
        } else if (s.length() <= 6) {
            return true;
        }
        return false;
    }
}
