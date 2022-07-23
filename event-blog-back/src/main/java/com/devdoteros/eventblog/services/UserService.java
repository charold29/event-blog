package com.devdoteros.eventblog.services;

import com.devdoteros.eventblog.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
