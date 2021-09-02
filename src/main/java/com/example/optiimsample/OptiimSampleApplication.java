package com.example.optiimsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class OptiimSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OptiimSampleApplication.class, args);
    }

}
