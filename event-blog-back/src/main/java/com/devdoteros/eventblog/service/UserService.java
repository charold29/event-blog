package com.devdoteros.eventblog.service;

import com.devdoteros.eventblog.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
