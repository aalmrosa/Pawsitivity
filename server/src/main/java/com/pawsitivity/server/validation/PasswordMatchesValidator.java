package com.pawsitivity.server.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    private String password;
    private String confirmPassword;

    @Override
    public void initialize(PasswordMatches matches){
        this.password = matches.password();
        this.confirmPassword = matches.confirmPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext){
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmPassword);
        return passwordValue != null && passwordValue.equals(confirmPasswordValue);
    }
}
