package com.example.validating.validate;

import com.example.validating.bean.User;
import com.example.validating.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class UserValidate implements Validator {
    @Autowired
    private IUserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getDate() == null) {
            errors.rejectValue("date","date.empty","date invalid");
        } else if (user.getDate().before(new Date())) {
            errors.rejectValue("date","date.invalid","date must be greater than the current date");
        }
    }
}
