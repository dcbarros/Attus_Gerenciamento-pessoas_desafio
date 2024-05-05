package com.gerencia_pessoas.gerencia_pessoas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gerencia_pessoas.gerencia_pessoas.model.Address;
import com.gerencia_pessoas.gerencia_pessoas.model.Person;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.PersonRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.PersonUpdateRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.response.PersonResponseDto;
import com.gerencia_pessoas.gerencia_pessoas.repository.PersonRepository;
import com.gerencia_pessoas.gerencia_pessoas.service.PersonService;
import com.gerencia_pessoas.gerencia_pessoas.utils.CepUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public void createNewPerson(PersonRequestDto request) {
        request.getAddress().setCep(CepUtils.formatCep(request.getAddress().getCep()));
        if(!CepUtils.isValidCep(CepUtils.formatCep(request.getAddress().getCep()))) {
            throw new RuntimeException("CEP fornecido não é válido");
        }
        Address address = modelMapper.map(request.getAddress(), Address.class);
        address.setIsPrincipal(true);
        Person person = new Person(request.getName(), request.getBirthday(), Set.of(address));
        this.personRepository.save(person);
    }

    @Override
    public void updatePerson(UUID uuid, PersonUpdateRequestDto request) {
        Person person = this.personRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        person.setName(request.getName());
        person.setBirthday(request.getBirthday());
        person.setUpdatedAt(LocalDateTime.now());
        this.personRepository.save(person);   
    }

    @Override
    public PersonResponseDto getPersonByUuid(UUID uuid) {
        Person person = this.personRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return this.modelMapper.map(person,PersonResponseDto.class);
    }

    @Override
    public List<PersonResponseDto> getPersonByName(String name) {
        return this.personRepository.findByNameIgnoreCaseContaining(name)
            .stream()
            .map(person -> this.modelMapper.map(person, PersonResponseDto.class))
            .collect(Collectors.toList());
    }   
}
