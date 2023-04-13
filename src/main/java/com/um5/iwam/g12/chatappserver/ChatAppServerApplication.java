package com.um5.iwam.g12.chatappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ChatAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatAppServerApplication.class, args);
    }

}
