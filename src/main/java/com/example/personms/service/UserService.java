package com.example.personms.service;

import com.example.personms.dto.UserDTO;
import com.example.personms.entity.PersonEntity;
import com.example.personms.entity.UserEntity;
import com.example.personms.mapper.UserMapper;
import com.example.personms.repository.NumberRepo;
import com.example.personms.repository.PersonRepo;
import com.example.personms.repository.UserRepo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo repo;
    private final PersonRepo personRepo;
    private final NumberRepo numberRepo;

    public UserService(UserRepo repo, PersonRepo personRepo, NumberRepo numberRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
        this.numberRepo = numberRepo;
    }

    public void registration(String fin, String prefiks, String number, UserEntity entity){

        entity.setPerson(personRepo.getByFin(fin).orElseThrow());

        if (entity.getPerson().getNumber().stream().anyMatch(n -> Objects.equals(n.getPrefiks(), prefiks)
                    && Objects.equals(n.getNumber(), number))) {

                entity.setNumber("(" + prefiks + ") " + number);
        }

        repo.save(entity);
    }

    public void changePassword(String oldPass, UserEntity entity){

        UserEntity user = repo.getByUsername(entity.getUsername());

        if (Objects.equals(user.getPassword(), oldPass)){
            user.setPassword(entity.getPassword());
        }
        repo.save(user);
    }


    public void changePin(UserEntity entity){
        UserEntity user = repo.getByUsername(entity.getUsername());

        user.setAppPin(entity.getAppPin());
        repo.save(user);
    }

    public void changeNumber(UserEntity entity){
        UserEntity user = repo.getByUsername(entity.getUsername());
        PersonEntity person = entity.getPerson();

        user.setNumber(entity.getNumber());

        repo.save(user);
    }

    public List<UserDTO> getAll(){
       return UserMapper.Mapping.mapToDtoList(repo.findAll());
    }

    public UserDTO getByUsername(String uname){
        return UserMapper.Mapping.mapToDto(repo.getByUsername(uname));
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public void deleteByUsername(String uname){
        repo.deleteByUsername(uname);
    }
}

