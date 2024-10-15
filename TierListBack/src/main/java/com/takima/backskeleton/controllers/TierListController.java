package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.DTO.TierListDto;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.TierList;
import com.takima.backskeleton.services.StudentService;
import com.takima.backskeleton.services.TierListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RequestMapping("TierLists")
@RestController
public class TierListController {

 private final TierListService TierListService;


    public TierListController(TierListService tierListService) {
        TierListService = tierListService;
    }

    @GetMapping("")
    public List<TierList> listTierList() {
        return TierListService.findAll();
    }

    @GetMapping("/{id}")
    public TierList getTierListById(@PathVariable Long id) {
        return TierListService.getTierListById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTierList(@PathVariable Long id) {
        TierListService.deleteById(id);
    }

    @PostMapping("")
    public void addTierList(@RequestBody StudentDto studentDto) {
        TierListService.addTierList(studentDto);
    }

    @PostMapping("/{id}")
    public void updateTierList(@RequestBody TierListDto tierListDto, @PathVariable Long id) {
        TierListService.updateTierList(tierListDto, id);
    }
}
