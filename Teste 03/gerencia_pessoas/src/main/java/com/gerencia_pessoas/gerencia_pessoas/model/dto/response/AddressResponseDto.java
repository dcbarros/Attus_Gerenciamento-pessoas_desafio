package com.gerencia_pessoas.gerencia_pessoas.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDto {
    private String cep;
    private String publicPlace;
    private Integer number;
    private String city;
    private String state;
    private Boolean isPrincipal;
}
