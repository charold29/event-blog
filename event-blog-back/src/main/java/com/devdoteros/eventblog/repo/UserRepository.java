package com.devdoteros.eventblog.repo;

import com.devdoteros.eventblog.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
