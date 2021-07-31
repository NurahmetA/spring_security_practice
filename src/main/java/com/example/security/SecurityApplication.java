package com.example.security;

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "smith", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Kairat Nurtas", "kairosh", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Imanbek Remix", "imanbek", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("smith", "ROLE_ADMIN");
            userService.addRoleToUser("kairosh", "ROLE_MANAGER");
            userService.addRoleToUser("kairosh", "ROLE_ADMIN");
            userService.addRoleToUser("kairosh", "ROLE_USER");
            userService.addRoleToUser("kairosh", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("imanbek", "ROLE_MANAGER");

        };
    }
}
