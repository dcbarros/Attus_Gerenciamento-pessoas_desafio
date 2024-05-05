package com.gerencia_pessoas.gerencia_pessoas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.PersonRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.PersonUpdateRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.response.PersonResponseDto;
import com.gerencia_pessoas.gerencia_pessoas.service.PersonService;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/person/v1")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createNewUser(@RequestBody PersonRequestDto request) {
        this.personService.createNewPerson(request);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable UUID uuid, @RequestBody PersonUpdateRequestDto request) {
        this.personService.updatePerson(uuid, request);
    }

    @GetMapping("/{uuid}")
    public PersonResponseDto getPersonByUuid(@PathVariable UUID uuid) {
        return this.personService.getPersonByUuid(uuid);
    }

    @GetMapping("/list")
    public List<PersonResponseDto> getPeopleByName(@RequestParam String name) {
        return this.personService.getPersonByName(name);
    }
    
    
}
