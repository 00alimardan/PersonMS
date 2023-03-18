package com.example.personms.repository;

import com.example.personms.entity.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepo extends JpaRepository<NumberEntity, Long> {
}
