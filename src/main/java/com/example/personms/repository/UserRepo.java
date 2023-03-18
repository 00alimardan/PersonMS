package com.example.personms.repository;

import com.example.personms.entity.PersonEntity;
import com.example.personms.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserRepo extends JpaRepository<UserEntity, Long> {
    boolean existsByNumber(String number);

    UserEntity getByUsername(String username);

    void deleteByUsername(String username);

    @Query("SELECT u.person FROM UserEntity u")
    List<PersonEntity> findAllPersons();
}
