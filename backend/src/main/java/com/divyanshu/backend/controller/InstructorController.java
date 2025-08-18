package com.hashedin.huspark.controller;


import com.hashedin.huspark.Exception.NotFoundException;
import com.hashedin.huspark.model.Instructor;
import com.hashedin.huspark.model.Role;
import com.hashedin.huspark.model.User;
import com.hashedin.huspark.repository.InstructorRepository;
import com.hashedin.huspark.repository.UserRepository;
import com.hashedin.huspark.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class InstructorController {


    @Autowired
    InstructorService instructorService;


    @Autowired
    UserRepository userRepository;


    @PostMapping(value = "/joinAsInstructor/{userId}")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor, @PathVariable int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        user.setRole(Role.INSTRUCTOR);
        userRepository.save(user);
        instructor.setUser(user);
        Instructor instructor1 = instructorService.addInstructor(instructor);
        return ResponseEntity.ok(instructor1);
    }


}
