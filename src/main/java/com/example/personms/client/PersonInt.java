package com.example.personms.client;

import com.example.personms.client.model.Person2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "person", url = "http://localhost:9090/ums/person")
public interface PersonInt {
    @GetMapping("/persons")
    List<Person2> getPersons();
}
