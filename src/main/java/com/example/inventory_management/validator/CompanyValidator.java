package com.example.inventory_management.validator;

import com.example.inventory_management.dto.AddressDTO;
import com.example.inventory_management.dto.CompanyDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator {
    public static List<String> validate(CompanyDTO companyDTO){
        List<String> errors = new ArrayList<>();

        if(companyDTO == null){
            return errors;
        }

        if(StringUtils.hasLength(companyDTO.getName())){
            errors.add(ValidatorConstant.REQUIRED_COMPANY_NAME);
        }

        if(StringUtils.hasLength(companyDTO.getTel())){
            errors.add(ValidatorConstant.REQUIRED_COMPANY_TEL);
        }

        if(StringUtils.hasLength(companyDTO.getMail())){
            errors.add(ValidatorConstant.REQUIRED_USER_MAIL);
        }

        if(AddressValidator.validate(companyDTO.getAddress()).size()!=0){
            errors.add(ValidatorConstant.REQUIRED_COMPANY_ADDRESS);
        }

        return errors;
    }
}
