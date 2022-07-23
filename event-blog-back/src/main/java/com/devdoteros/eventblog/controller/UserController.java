package com.devdoteros.eventblog.controller;

import com.devdoteros.eventblog.model.entity.User;
import com.devdoteros.eventblog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result) {
        // Validate filled fields
        if (result.hasErrors()) {
            return validate(result);
        }
        // Validate repeated email
        if (userService.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("message", "Existe un usuario con ese correo"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> editUser(@Valid @RequestBody User user, @PathVariable Long userId, BindingResult result) {
        // Validate filled fields
        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User userDb = optionalUser.get();
            // When the email you want to replace already exists.
            if (!user.getEmail().equalsIgnoreCase(userDb.getEmail()) &&
                    userService.findByEmail(user.getEmail()).isPresent() &&
                    !user.getEmail().isEmpty()) {
                return ResponseEntity.badRequest()
                        .body(Collections.singletonMap("message", "Existe un usuario con ese correo"));
            }
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
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            userService.deleteById(userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(fieldError -> {
                    String errorField = fieldError.getField();
                    String defaultMessage = fieldError.getDefaultMessage();
                    errors.put(errorField, "El campo " + errorField + " " + defaultMessage);
                }
        );
        return ResponseEntity.badRequest().body(errors);
    }
}
