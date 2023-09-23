package com.ivoyant.SpringJdbcTemplate.controller;

import com.ivoyant.SpringJdbcTemplate.dao.UserRepository;
import com.ivoyant.SpringJdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {

        return userRepository.saveUser(user);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {

        return userRepository.updateUser(user);

    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.getById(id);
    }

    @GetMapping("/getAll")
    public List<User> getUsers() {
        return userRepository.allUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){

            return userRepository.deleteById(id);



    }

}
