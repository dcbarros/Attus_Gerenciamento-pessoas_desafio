package com.gerencia_pessoas.gerencia_pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerencia_pessoas.gerencia_pessoas.model.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;



public interface PersonRepository extends JpaRepository<Person,Long>{
    Optional<Person> findByUuid(UUID uuid);
    List<Person> findByName(String name);
}
