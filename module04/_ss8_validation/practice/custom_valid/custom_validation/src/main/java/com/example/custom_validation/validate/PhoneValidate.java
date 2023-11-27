package com.example.custom_validation.validate;

import com.example.custom_validation.bean.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PhoneValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber =(PhoneNumber) target;

        if (phoneNumber.getPhone().matches("[0-9]")){
            errors.rejectValue("phone","number.match");
        }else if (phoneNumber.getPhone().length() > 11 || phoneNumber.getPhone().length() < 10) {
            errors.rejectValue("phone","number.length");
        } else if (phoneNumber.getPhone().startsWith("0")) {
            errors.rejectValue("phone","number.startsWith");
        } else if (phoneNumber.getPhone() == "") {
            errors.rejectValue("phone","number.empty");
        }
    }
}
