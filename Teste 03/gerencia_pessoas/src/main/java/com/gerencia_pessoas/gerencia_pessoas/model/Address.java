package com.gerencia_pessoas.gerencia_pessoas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O cep deve ser informado")
    private String cep;
    @NotBlank(message = "O logradouro deve ser informado")
    private String publicPlace;
    @NotNull(message = "O número deve ser informado, caso não possua deve ser atribuido o número 0")
    private Integer number;
    @NotBlank(message = "A Cidade deve ser informada")
    private String city;
    @NotBlank(message = "O Estado deve ser informado")
    private String state;
    private Boolean isPrincipal;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
