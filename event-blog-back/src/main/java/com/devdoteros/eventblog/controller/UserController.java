package com.devdoteros.eventblog.controller;

import com.devdoteros.eventblog.model.entity.User;
import com.devdoteros.eventblog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Long userId){
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()){
            User userDb = optionalUser.get();
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setPassword(user.getPassword());
            userDb.setUsername(user.getUsername());
            userDb.setAge(user.getAge());
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()){
            userService.deleteById(userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
