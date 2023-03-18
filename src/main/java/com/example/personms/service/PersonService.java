package com.example.personms.service;

import com.example.personms.dto.PersonDTO;
import com.example.personms.entity.NumberEntity;
import com.example.personms.entity.PersonEntity;
import com.example.personms.entity.UserEntity;
import com.example.personms.mapper.PersonMapper;
import com.example.personms.repository.NumberRepo;
import com.example.personms.repository.PersonRepo;
import com.example.personms.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class PersonService {

    private final PersonRepo repo;
    private final UserRepo userRepo;
    private final NumberRepo numberRepo;
    public PersonService(PersonRepo repo, UserRepo userRepo, NumberRepo numberRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.numberRepo = numberRepo;
    }

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);


    public void save(PersonEntity entity){

        repo.save(entity);

    }
    public void addNumber(Long pId, Long nId){
        PersonEntity person = repo.getById(pId);
        NumberEntity number = numberRepo.getById(nId);

            person.getNumber().add(number);


        repo.save(person);
    }



    public List<PersonDTO> getAll(){
        List<PersonEntity> persons = userRepo.findAllPersons();

            return PersonMapper.Mapping.mapToDtoList(persons);

    }

    public PersonDTO getByFin(String fin){
        List<UserEntity> users = userRepo.findAll();

        if (users.stream().anyMatch(t -> Objects.equals(t.getPerson().getFin(), fin))) {
            return PersonMapper.Mapping.mapToDto(repo.getByFin(fin).orElseThrow());
        }
        else throw new RuntimeException();
    }


    public PersonDTO getByNumber(String prefiks, String number, UserEntity user) {
        if (!userRepo.existsByNumber(user.getNumber())) {
            return repo.findAll().stream()
                    .filter(x -> x.getNumber().stream().anyMatch(y ->
                            Objects.equals(y.getPrefiks(), prefiks) && Objects.equals(y.getNumber(), number)))
                    .map(PersonMapper.Mapping::mapToDto)
                    .findAny()
                    .orElseThrow(() -> new EntityNotFoundException("Person with number '(" + prefiks
                            + ") " + number + "' not found"));
        }
        else throw new RuntimeException();
    }
}
