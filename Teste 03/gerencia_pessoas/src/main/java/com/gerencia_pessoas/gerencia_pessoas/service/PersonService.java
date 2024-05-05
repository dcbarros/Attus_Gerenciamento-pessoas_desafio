package com.gerencia_pessoas.gerencia_pessoas.service;

import java.util.List;
import java.util.UUID;

import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.PersonRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.PersonUpdateRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.response.PersonResponseDto;


public interface PersonService {
    void createNewPerson(PersonRequestDto request);
    void updatePerson(UUID uuid, PersonUpdateRequestDto request);
    PersonResponseDto getPersonByUuid(UUID uuid);
    List<PersonResponseDto> getPersonByName(String name);
}
