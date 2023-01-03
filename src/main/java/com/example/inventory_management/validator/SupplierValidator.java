package com.example.inventory_management.validator;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.dto.SupplierDTO;
import com.example.inventory_management.dto.UserDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {
    public static List<String> validate(SupplierDTO supplierDTO){
        List<String> errors = new ArrayList<>();

        if(supplierDTO == null){
            errors.add(ValidatorConstant.REQUIRED_USER_FIRSTNAME);
            errors.add(ValidatorConstant.REQUIRED_USER_LASTNAME);
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS);
            errors.add(ValidatorConstant.REQUIRED_USER_PASSWORD);
            return errors;
        }

        if(StringUtils.hasLength(supplierDTO.getFirstName())){
            errors.add(ValidatorConstant.REQUIRED_USER_FIRSTNAME);
        }

        if(StringUtils.hasLength(supplierDTO.getLastName())){
            errors.add(ValidatorConstant.REQUIRED_USER_LASTNAME);
        }

        if(StringUtils.hasLength(supplierDTO.getMail())){
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
        }

        if(AddressValidator.validate(supplierDTO.getAddress()).size()!=0){
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS);
        }

        return errors;
    }
}
