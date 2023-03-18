package com.example.personms.repository;

import com.example.personms.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> getByFin(String fin);


}
