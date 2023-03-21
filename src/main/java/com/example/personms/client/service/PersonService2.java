package com.example.personms.client.service;

import com.example.personms.client.PersonInt;
import com.example.personms.client.model.Person2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService2 {
    private final PersonInt personInt;

    public PersonService2(PersonInt personInt) {
        this.personInt = personInt;
    }


    public List<Person2> getAll(){
        return personInt.getPersons();
    }
}
