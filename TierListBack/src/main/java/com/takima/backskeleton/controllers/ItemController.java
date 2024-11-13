package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.ItemDto;
import com.takima.backskeleton.models.Item;
import com.takima.backskeleton.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("Items")//on laisse en majuscule
@RestController
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public List<Item> listItem() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
    }
//
//    @PostMapping("")
//    public void addItem(@RequestBody StudentDto studentDto) {
//        itemService.addItem(studentDto);
//    }
//
    @PatchMapping("/{id}")
    public void updateItem(@RequestBody ItemDto itemDto, @PathVariable Long id) {
        itemService.updateItem(itemDto, id);
    }
}