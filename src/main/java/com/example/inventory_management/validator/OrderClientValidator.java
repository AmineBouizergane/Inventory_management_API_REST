package com.example.inventory_management.validator;

import com.example.inventory_management.dto.OrderClientDTO;
import com.example.inventory_management.dto.UserDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderClientValidator {
    public static List<String> validate(OrderClientDTO orderClientDTO){
        List<String> errors = new ArrayList<>();

        if(orderClientDTO == null){
            errors.add(ValidatorConstant.REQUIRED_ORDER_CODE);
            errors.add(ValidatorConstant.REQUIRED_ORDER_CLIENT);
            errors.add(ValidatorConstant.REQUIRED_ORDER_DETAILS);
            return errors;
        }

        if(StringUtils.hasLength(orderClientDTO.getCode())){
            errors.add(ValidatorConstant.REQUIRED_ORDER_CODE);
        }

        if(orderClientDTO.getClient() == null){
            errors.add(ValidatorConstant.REQUIRED_ORDER_CLIENT);
        }

        if(orderClientDTO.getLineOrderClientList().size() > 0){
            errors.add(ValidatorConstant.REQUIRED_ORDER_DETAILS);
        }
        return errors;
    }


}
