package com.example.inventory_management.validator;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDTO clientDTO){
        List<String> errors = new ArrayList<>();

        if(clientDTO == null){
            errors.add(ValidatorConstant.REQUIRED_USER_FIRSTNAME);
            errors.add(ValidatorConstant.REQUIRED_USER_LASTNAME);
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
            errors.add(ValidatorConstant.REQUIRED_USER_PASSWORD);
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS);
            return errors;
        }

        if(StringUtils.hasLength(clientDTO.getFirstName())){
            errors.add(ValidatorConstant.REQUIRED_USER_FIRSTNAME);
        }

        if(StringUtils.hasLength(clientDTO.getLastName())){
            errors.add(ValidatorConstant.REQUIRED_USER_LASTNAME);
        }

        if(StringUtils.hasLength(clientDTO.getMail())){
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
        }

        if(AddressValidator.validate(clientDTO.getAddress()).size()!=0){
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS);
        }

        return errors;
    }
}
