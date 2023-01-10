package com.example.inventory_management.validator;

import com.example.inventory_management.dto.LineOrderClientDTO;
import com.example.inventory_management.dto.OrderClientDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LineOrderClientValidator {
    public static List<String> validate(LineOrderClientDTO lineOrderClientDTO){
        List<String> errors = new ArrayList<>();

        if(lineOrderClientDTO == null){
            errors.add(ValidatorConstant.REQUIRED_ORDER_CODE);
            errors.add(ValidatorConstant.REQUIRED_ORDER_CLIENT);
            errors.add(ValidatorConstant.REQUIRED_ORDER_DETAILS);
            return errors;
        }

        if(lineOrderClientDTO.getItem() == null){
            errors.add(ValidatorConstant.REQUIRED_LINE_ORDER_ITEM);
        }

        if(lineOrderClientDTO.getQte().signum() > 0){
            errors.add(ValidatorConstant.REQUIRED_LINE_ORDER_QTE);
        }

        if(lineOrderClientDTO.getUnitePrice().signum() > 0){
            errors.add(ValidatorConstant.REQUIRED_LINE_ORDER_UNITE_PRICE);
        }
        return errors;
    }
}
