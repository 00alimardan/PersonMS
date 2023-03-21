package com.example.personms;

import com.example.personms.entity.UserEntity;
import com.example.personms.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@EnableFeignClients
@SpringBootApplication
public class PersonMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonMsApplication.class, args);
    }

}
