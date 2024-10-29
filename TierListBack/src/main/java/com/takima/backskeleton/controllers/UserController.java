package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("Users")//on laisse en majuscule
@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> listUser() {
        return userService.findAll();
    }

//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteById(id);
//    }

//    @PostMapping("")
//    public void addUser(@RequestBody StudentDto studentDto) {
//        userService.addUser(studentDto);
//    }

//    @PostMapping("/{id}")
//    public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
//        userService.updateUser(userDto, id);
//    }
}