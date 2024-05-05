package com.gerencia_pessoas.gerencia_pessoas.model.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateRequestDto {
    private String name;
    private LocalDate birthday;
}
