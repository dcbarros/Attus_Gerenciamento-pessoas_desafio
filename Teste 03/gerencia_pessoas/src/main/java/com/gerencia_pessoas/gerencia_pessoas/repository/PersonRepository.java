package com.gerencia_pessoas.gerencia_pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerencia_pessoas.gerencia_pessoas.model.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;



public interface PersonRepository extends JpaRepository<Person,Long>{
    Optional<Person> findByUuid(UUID uuid);
    @Query("SELECT p FROM Person p WHERE lower(p.name) like lower(concat('%', :name,'%'))")
    List<Person> findByNameIgnoreCaseContaining(String name);
}
