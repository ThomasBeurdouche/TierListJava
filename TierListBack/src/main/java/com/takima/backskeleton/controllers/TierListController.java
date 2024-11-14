package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.TierListDto;
import com.takima.backskeleton.models.TierList;
import com.takima.backskeleton.services.TierListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("TierLists")
@RestController
public class TierListController {

    private final TierListService tierListService;

    @Autowired
    public TierListController(TierListService tierListService) {
        this.tierListService = tierListService;
    }

    @GetMapping("")
    public List<TierList> listTierList() {
        return tierListService.findAll();
    }

    @GetMapping("/{id}")
    public TierList getTierListById(@PathVariable Long id) {
        return tierListService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTierList(@PathVariable Long id) {
        tierListService.deleteById(id);
    }

    @PostMapping("")
    public void addTierList(@RequestBody TierListDto tierListDto) {
        tierListService.addTierList(tierListDto);
    }

    @PatchMapping("/{id}")
    public void updateTierList(@RequestBody TierListDto tierListDto, @PathVariable Long id) {
        tierListService.updateTierList(tierListDto, id);
    }
}