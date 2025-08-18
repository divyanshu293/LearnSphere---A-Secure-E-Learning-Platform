package com.hashedin.huspark.controller;


import com.hashedin.huspark.dao.UserDto;
import com.hashedin.huspark.model.User;
import com.hashedin.huspark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;




    @PutMapping("/edit/{userId}")
    public UserDto editUser(@PathVariable int userId, @RequestBody User user) {
        return userService.editUser(userId, user);
    }


    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }


    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.listUsers();
    }


    @PostMapping("/{userId}/takecourse/{courseId}")
    public User takeCourse(@PathVariable int userId, @PathVariable int courseId) {
        return userService.takeCourse(userId, courseId);
    }


}
