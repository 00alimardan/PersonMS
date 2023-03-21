package com.example.personms.controller;

import com.example.personms.dto.PersonDTO;
import com.example.personms.entity.PersonEntity;
import com.example.personms.entity.UserEntity;
import com.example.personms.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonCtrl {

    private final PersonService service;

    public PersonCtrl(PersonService service) {
        this.service = service;
    }




    @GetMapping("/all")
    public List<PersonDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/byFIN/{fin}")
    public PersonDTO getByFin(@PathVariable String fin){

        return service.getByFin(fin);
    }


    @GetMapping("/byNum/{prefiks}/{number}")
    public PersonDTO getByNumberId(@PathVariable String prefiks, @PathVariable String  number,
                                   UserEntity user){

        return service.getByNumber(prefiks, number, user);
    }







//    @PostMapping("/save")
//    public void save(@RequestBody PersonEntity entity){
//        service.save(entity);
//    }
//    @PostMapping("/add/{pId}/{nId}")
//    public void addNumber(@PathVariable Long pId, @PathVariable Long nId){
//        service.addNumber(pId, nId);
//    }
}
