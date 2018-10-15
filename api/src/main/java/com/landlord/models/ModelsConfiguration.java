package com.landlord.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelsConfiguration {
    @Bean
    public Class<User> provideUserClass() {
        return User.class;
    }
}
