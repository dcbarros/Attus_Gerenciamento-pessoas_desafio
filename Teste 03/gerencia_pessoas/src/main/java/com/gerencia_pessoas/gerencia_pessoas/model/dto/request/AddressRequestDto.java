package com.gerencia_pessoas.gerencia_pessoas.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {
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
}
