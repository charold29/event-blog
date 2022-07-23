package com.devdoteros.eventblog.repositories;

import com.devdoteros.eventblog.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
