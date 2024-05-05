package com.gerencia_pessoas.gerencia_pessoas.model.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto {
    private String name;
    private UUID uuid;
    private LocalDate birthday;
    private List<AddressResponseDto> addresses;
}
