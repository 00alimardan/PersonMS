package com.example.personms.controller;


import com.example.personms.entity.PersonEntity;
import com.example.personms.entity.UserEntity;
import com.example.personms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@RequestMapping("/user")
public class UserCtrl {
    private final UserService service;

    public UserCtrl(UserService service) {
        this.service = service;
    }

    @PostMapping("/save/{fin}/{prefiks}/{number}")
    public void registration(@PathVariable String fin, @PathVariable String prefiks,
                             @PathVariable String number, @RequestBody UserEntity entity){
        service.registration(fin, prefiks, number, entity);
    }


    @PutMapping("/pass/{oldPass}")
    public void changePassword(@PathVariable String oldPass, @RequestBody UserEntity entity){
        service.changePassword(oldPass, entity);
    }

    @PutMapping("/pin")
    public void changePin(@RequestBody UserEntity entity){
        service.changePin(entity);
    }

    @PutMapping("/number")
    public void changeNumber(@RequestBody UserEntity entity){
        service.changeNumber(entity);
    }
}
