package com.gerencia_pessoas.gerencia_pessoas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gerencia_pessoas.gerencia_pessoas.model.Address;
import com.gerencia_pessoas.gerencia_pessoas.model.Person;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.AddressRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.response.AddressResponseDto;
import com.gerencia_pessoas.gerencia_pessoas.repository.AddressRepository;
import com.gerencia_pessoas.gerencia_pessoas.repository.PersonRepository;
import com.gerencia_pessoas.gerencia_pessoas.service.AddressService;
import com.gerencia_pessoas.gerencia_pessoas.utils.CepUtils;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressImpl implements AddressService{

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addNewAddressToPerson(UUID uuid, List<AddressRequestDto> addresses) {
        Person person = this.personRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
        addresses.stream()
            .filter(addressDto -> !this.addressRepository.existsAddressByPersonIdAndCep(person.getId(), addressDto.getCep()))
            .forEach(addressDto -> {
                Address address = this.modelMapper.map(addressDto, Address.class);
                address.setIsPrincipal(false);
                person.getAddresses().add(address);
            });
        person.setUpdatedAt(LocalDateTime.now());
        this.personRepository.save(person);
    }

    @Override
    public void updateAddressByUuidAndCep(UUID uuid, String cep, AddressRequestDto newAddressRequestDto) {
        cep = CepUtils.formatCep(cep);
        if(!CepUtils.isValidCep(cep)) {
            throw new RuntimeException("CEP fornecido não é válido");
        }
        Address address = this.addressRepository.findAddressByUuidAndCep(uuid, cep).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));        
        address.setCep(newAddressRequestDto.getCep());
        address.setPublicPlace(newAddressRequestDto.getPublicPlace());
        address.setNumber(newAddressRequestDto.getNumber());
        address.setCity(newAddressRequestDto.getCity());
        address.setState(newAddressRequestDto.getState());
        this.addressRepository.save(address);
    }

    @Override
    public List<AddressResponseDto> getAllAddressByUuid(UUID uuid) {
        Person person = this.personRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
        return person.getAddresses()
            .stream()
            .map(address -> this.modelMapper.map(address, AddressResponseDto.class)
            ).toList();
    }

    @Override
    public AddressResponseDto getAddressByUuidAndCep(UUID uuid, String cep){
        cep = CepUtils.formatCep(cep);
        if(!CepUtils.isValidCep(cep)) {
            throw new RuntimeException("CEP fornecido não é válido");
        }
        Address address = this.addressRepository.findAddressByUuidAndCep(uuid, cep).orElseThrow(() -> new RuntimeException("Endereço naao encontrado!"));
        return this.modelMapper.map(address, AddressResponseDto.class);
    }

    @Override
    @Transactional
    public void updatePrincipalAddressToPersonByUuidAndCep(UUID uuid, String cep) {
        cep = CepUtils.formatCep(cep);
        if(!CepUtils.isValidCep(cep)) {
            throw new RuntimeException("CEP fornecido não é válido");
        }
        if(this.addressRepository.existsAddressByPersonUuidAndCep(uuid, cep)){
            Person person = this.personRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
            this.addressRepository.changePrincipalAddressToFalse(uuid);
            this.addressRepository.modifyingPrincipalAddressByUuidAndCep(uuid, cep);
            person.setUpdatedAt(LocalDateTime.now());
            this.personRepository.save(person);
        }else{
            throw new RuntimeException("Pessoa ou endereço não encontrado.");
        }
    }  
}
