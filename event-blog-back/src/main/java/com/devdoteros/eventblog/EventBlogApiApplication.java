package com.devdoteros.eventblog;

import com.devdoteros.eventblog.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EventBlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventBlogApiApplication.class, args);
	}

}
