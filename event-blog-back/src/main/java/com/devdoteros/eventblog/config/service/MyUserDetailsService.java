package com.devdoteros.eventblog.config.service;

import com.devdoteros.eventblog.config.model.MyUserDetails;
import com.devdoteros.eventblog.model.entity.User;
import com.devdoteros.eventblog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            return new MyUserDetails(optionalUser.get());
        }

        throw new UsernameNotFoundException("Could not find user");
    }
}
