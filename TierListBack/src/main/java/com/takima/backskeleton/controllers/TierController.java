package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Tier;
import com.takima.backskeleton.services.TierService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("Tiers")//on laisse en majuscule
@RestController
public class TierController {

    private final TierService tierService;


    public TierController(TierService tierService) {
        this.tierService = tierService;
    }

    @GetMapping("")
    public List<Tier> listTier() {
        return tierService.findAll();
    }

//    @GetMapping("/{id}")
//    public Tier getTierById(@PathVariable Long id) {
//        return tierService.getTierById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTier(@PathVariable Long id) {
//        tierService.deleteById(id);
//    }
//
//    @PostMapping("")
//    public void addTier(@RequestBody StudentDto studentDto) {
//        tierService.addTier(studentDto);
//    }
//
//    @PostMapping("/{id}")
//    public void updateTier(@RequestBody TierDto tierDto, @PathVariable Long id) {
//        tierService.updateTier(tierDto, id);
//    }
}