package com.example.inventory_management.validator;

import com.example.inventory_management.dto.ItemDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {
    public static List<String> validate(ItemDTO itemDTO){
        List<String> errors = new ArrayList<>();

        if(itemDTO == null){
            errors.add(ValidatorConstant.REQUIRED_ITEM_CODE);
            errors.add(ValidatorConstant.REQUIRED_ITEM_DESIGNATION);
            errors.add(ValidatorConstant.REQUIRED_ITEM_PRICE_HT);
            errors.add(ValidatorConstant.ITEM_PRICE_HT_NEGATIVE);
            errors.add(ValidatorConstant.REQUIRED_ITEM_TVA);
            errors.add(ValidatorConstant.ITEM_TVA_NEGATIVE);
            errors.add(ValidatorConstant.REQUIRED_ITEM_CATEGORY);
            return errors;
        }

        if(StringUtils.hasLength(itemDTO.getCodeItem())){
            errors.add(ValidatorConstant.REQUIRED_ITEM_CODE);
        }

        if(StringUtils.hasLength(itemDTO.getDesignation())){
            errors.add(ValidatorConstant.REQUIRED_ITEM_DESIGNATION);
        }

        if(itemDTO.getUnitPriceHT() == null){
            errors.add(ValidatorConstant.REQUIRED_ITEM_PRICE_HT);
        }

        if(itemDTO.getUnitPriceHT().signum() < 0){
            errors.add(ValidatorConstant.ITEM_PRICE_HT_NEGATIVE);
        }

        if(itemDTO.getTva() == null){
            errors.add(ValidatorConstant.REQUIRED_ITEM_TVA);
        }

        if(itemDTO.getTva().signum() < 0){
            errors.add(ValidatorConstant.ITEM_TVA_NEGATIVE);
        }

        if(itemDTO.getCategory() == null){
            errors.add(ValidatorConstant.REQUIRED_ITEM_CATEGORY);
        }

        return errors;
    }
}
