package com.example.inventory_management.controle.api;

import com.example.inventory_management.dto.ItemDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

public interface ItemApi {
    @PostMapping(value = "/item/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDTO save(@RequestBody ItemDTO itemDTO);
    @GetMapping(value = "/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDTO findById(@PathVariable Integer id);
    @GetMapping(value = "/item/{codeItem}", produces = MediaType.APPLICATION_JSON_VALUE)
    ItemDTO findByCodeItem(@PathVariable String codeItem);
    @GetMapping(value = "/item/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ItemDTO> findAll();
    @DeleteMapping(value = "/item/{id}")
    void delete(Integer id);
}
