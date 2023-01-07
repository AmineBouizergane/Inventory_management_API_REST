package com.example.inventory_management.controle;

import com.example.inventory_management.controle.api.ItemApi;
import com.example.inventory_management.dto.ItemDTO;
import com.example.inventory_management.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController implements ItemApi {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }
    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        return itemService.save(itemDTO);
    }

    @Override
    public ItemDTO findById(Integer id) {
        return itemService.findById(id);
    }

    @Override
    public ItemDTO findByCodeItem(String codeItem) {
        return itemService.findByCodeItem(codeItem);
    }

    @Override
    public List<ItemDTO> findAll() {
        return itemService.findAll();
    }

    @Override
    public void delete(Integer id) {
        itemService.delete(id);
    }
}
