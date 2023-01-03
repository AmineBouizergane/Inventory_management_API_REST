package com.example.inventory_management.validator;

import com.example.inventory_management.dto.UserDTO;
import com.example.inventory_management.model.User;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDTO userDTO){
        List<String> errors = new ArrayList<>();

        if(userDTO == null){
            errors.add(ValidatorConstant.REQUIRED_USER_FIRSTNAME);
            errors.add(ValidatorConstant.REQUIRED_USER_LASTNAME);
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
            errors.add(ValidatorConstant.REQUIRED_USER_PASSWORD);
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS);
            return errors;
        }

        if(StringUtils.hasLength(userDTO.getFirstName())){
            errors.add(ValidatorConstant.REQUIRED_USER_FIRSTNAME);
        }

        if(StringUtils.hasLength(userDTO.getLastName())){
            errors.add(ValidatorConstant.REQUIRED_USER_LASTNAME);
        }

        if(StringUtils.hasLength(userDTO.getMail())){
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
        }

        if(StringUtils.hasLength(userDTO.getPassword())){
            errors.add(ValidatorConstant.REQUIRED_USER_PASSWORD);
        }

        if(AddressValidator.validate(userDTO.getAddress()).size()!=0){
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS);
        }

        return errors;
    }

}
