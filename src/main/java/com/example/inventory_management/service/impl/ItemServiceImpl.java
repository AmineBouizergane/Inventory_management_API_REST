package com.example.inventory_management.service.impl;

import com.example.inventory_management.dto.ItemDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.Item;
import com.example.inventory_management.repository.ItemRepos;
import com.example.inventory_management.service.ItemService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.ItemValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private ItemRepos itemRepos;

    @Autowired
    public ItemServiceImpl(ItemRepos itemRepos) {
        this.itemRepos=itemRepos;
    }
    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        List<String> errors = ItemValidator.validate(itemDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid item", itemDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_ITEM, ErrorCodes.ITEM_NOT_VALID, errors);
        }
        return ItemDTO.fromEntity(
                itemRepos.save(ItemDTO.toEntity(itemDTO))
        );
    }

    @Override
    public ItemDTO findById(Integer id) {
        if(id == null){
            log.error("Invalid Item id");
            return null;
        }

        Optional<Item> item = itemRepos.findById(id);
        ItemDTO itemDTO = ItemDTO.fromEntity(item.get());
        return Optional.of(itemDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.INVALID_ITEM, ErrorCodes.ITEM_NOT_FOUND)
        );
    }

    @Override
    public ItemDTO findByCodeItem(String codeItem) {
        if(codeItem == null){
            log.error("Invalid Item Code");
            return null;
        }

        Optional<Item> item = itemRepos.findByCodeItem(codeItem);
        ItemDTO itemDTO = ItemDTO.fromEntity(item.get());
        return Optional.of(itemDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.INVALID_ITEM, ErrorCodes.ITEM_NOT_FOUND)
        );

    }

    @Override
    public List<ItemDTO> findAll() {
        return itemRepos.findAll().stream()
                .map(ItemDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Invalid Item id");
            return;
        }

        itemRepos.deleteById(id);
    }
}
