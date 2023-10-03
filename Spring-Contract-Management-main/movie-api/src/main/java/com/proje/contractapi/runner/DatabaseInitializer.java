package com.proje.contractapi.runner;

import com.proje.contractapi.model.Contract;
import com.proje.contractapi.model.User;
import com.proje.contractapi.security.oauth2.OAuth2Provider;
import com.proje.contractapi.service.ContractService;
import com.proje.contractapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.proje.contractapi.security.WebSecurityConfig;


import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {

        private final UserService userService;
        private final ContractService contractService;
        private final PasswordEncoder passwordEncoder;

        @Override
        public void run(String... args) {
                if (!userService.getUsers().isEmpty()) {
                        return;
                }
                USERS.forEach(user -> {
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        userService.saveUser(user);
                });
                MOVIES.forEach(contractService::saveContract);
                log.info("Database initialized");
        }

        private static final List<User> USERS = Arrays.asList(
                        new User("admin", "admin", "Admin", "admin@mycompany.com", WebSecurityConfig.ADMIN, null,
                                        OAuth2Provider.LOCAL, "1"),
                        new User("user", "user", "User", "user@mycompany.com", WebSecurityConfig.USER, null,
                                        OAuth2Provider.LOCAL,
                                        "2"));

        private static final List<Contract> MOVIES = Arrays.asList(
                        new Contract("100$", "A Şirket",
                                        "https://www.hloom.com/images/Vendor-Contract.jpg" ),
                        new Contract("200$", "B Şirket",
                                        "https://www.hloom.com/images/Vendor-Contract.jpg")
                        
                   
                        );
}
