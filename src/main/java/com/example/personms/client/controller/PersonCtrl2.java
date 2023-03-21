package com.example.personms.client.controller;

import com.example.personms.client.model.Person2;
import com.example.personms.client.service.PersonService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class PersonCtrl2 {
    public final PersonService2 service;

    public PersonCtrl2(PersonService2 service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Person2> getAll(){
        return service.getAll();
    }
}
