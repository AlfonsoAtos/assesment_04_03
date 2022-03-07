package com.Assessment.Users_WS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsersWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersWsApplication.class, args);
	}

}
