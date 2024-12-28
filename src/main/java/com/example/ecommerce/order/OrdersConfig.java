package com.example.ecommerce.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdersConfig {

    @Bean
    CommandLineRunner commandLineRunner(OrdersRepository repository) {
        return args -> {

        };
    }

}
