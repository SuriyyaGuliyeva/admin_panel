package com.apps.first_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}