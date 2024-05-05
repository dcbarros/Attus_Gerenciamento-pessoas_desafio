package com.gerencia_pessoas.gerencia_pessoas.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {

    private String cep;
    private String publicPlace;
    private Integer number;
    private String city;
    private String state;
}
