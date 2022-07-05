package com.senpiper.liv2train2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Liv2Train2Application {

    public static void main(String[] args) {
        SpringApplication.run(Liv2Train2Application.class, args);
    }

}
