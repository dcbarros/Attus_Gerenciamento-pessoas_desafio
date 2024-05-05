package com.gerencia_pessoas.gerencia_pessoas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String name;
    private LocalDate birthday;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Set<Address> addresses;

    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Person(String name, LocalDate birthday, Set<Address> addresses) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = birthday;
        this.addresses = addresses;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
}
