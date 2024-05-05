package com.gerencia_pessoas.gerencia_pessoas.model.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDto {
    @NotBlank(message = "O nome do usuário é obrigatório")
    private String name;
    @Past(message = "A data de nascimento deve ser atribuída a uma data anterior a hoje")
    private LocalDate birthday;
    private AddressRequestDto address;
}
