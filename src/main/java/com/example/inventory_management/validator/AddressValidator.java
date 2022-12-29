package com.example.inventory_management.validator;

import com.example.inventory_management.dto.AddressDTO;
import com.example.inventory_management.dto.CategoryDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {
    public static List<String> validate(AddressDTO addressDTO){
        List<String> errors = new ArrayList<>();

        if(addressDTO == null){
            errors.add(ValidatorConstant.REQUIRED_USER_COUNTRY);
            errors.add(ValidatorConstant.REQUIRED_USER_CITY);
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS1);
            errors.add(ValidatorConstant.REQUIRED_USER_ZIPCODE);
            return errors;
        }

        if(StringUtils.hasLength(addressDTO.getCountry())){
            errors.add(ValidatorConstant.REQUIRED_USER_COUNTRY);
        }

        if(StringUtils.hasLength(addressDTO.getCity())){
            errors.add(ValidatorConstant.REQUIRED_USER_CITY);
        }

        if(StringUtils.hasLength(addressDTO.getAddress1())){
            errors.add(ValidatorConstant.REQUIRED_USER_ADDRESS1);
        }

        if(StringUtils.hasLength(addressDTO.getZipCode())){
            errors.add(ValidatorConstant.REQUIRED_USER_ZIPCODE);
        }

        return errors;
    }
}
