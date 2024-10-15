package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.TierList;
import com.takima.backskeleton.services.StudentService;
import com.takima.backskeleton.services.TierListServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RequestMapping("students")
@RestController
public class TierListController {

 private final TierListServices TierListService;


    public TierListController(TierListServices tierListService) {
        TierListService = tierListService;
    }

    @GetMapping("")
    public List<TierList> listTierList() {
        return TierListService.findAll();
    }


=

    @GetMapping("/{id}")
    public Student getTierListById(@PathVariable Long id) {
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
    public void updateTierList(@RequestBody StudentDto TierListDto, @PathVariable Long id) {
        TierListService.updateTierList(TierListDto, id);
    }
}
