package com.example.personms.service;

import com.example.personms.entity.NumberEntity;
import com.example.personms.repository.NumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberService {

    private final NumberRepo repo;

    public NumberService(NumberRepo repo) {
        this.repo = repo;
    }

    public void save(NumberEntity entity){
        repo.save(entity);
    }


    public List<NumberEntity> getAll(){
        return repo.findAll();
    }


    public NumberEntity getById(Long id){

        return repo.getById(id);
    }
}
