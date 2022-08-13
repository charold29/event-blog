package com.devdoteros.eventblog.config.service;

import com.devdoteros.eventblog.config.model.MyUserDetails;
import com.devdoteros.eventblog.model.entity.User;
import com.devdoteros.eventblog.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User userDb = optionalUser.get();
            log.info(userDb.toString());
            return new MyUserDetails(userDb);
        }
        log.error("No encontrado");
        throw new UsernameNotFoundException("Could not find user");
    }
}
