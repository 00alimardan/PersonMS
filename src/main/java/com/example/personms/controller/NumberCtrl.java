package com.example.personms.controller;

import com.example.personms.entity.NumberEntity;
import com.example.personms.service.NumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/number")
public class NumberCtrl {

    private final NumberService service;

    public NumberCtrl(NumberService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void save(@RequestBody NumberEntity entity){
        service.save(entity);
    }


    @GetMapping("/all")
    public List<NumberEntity> getAll(){
        return service.getAll();
    }

    @GetMapping("/byID/{id}")
    public NumberEntity getById(@PathVariable Long id){

        return service.getById(id);
    }
}
