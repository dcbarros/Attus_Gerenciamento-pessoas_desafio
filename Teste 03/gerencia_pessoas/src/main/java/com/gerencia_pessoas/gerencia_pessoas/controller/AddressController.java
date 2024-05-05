package com.gerencia_pessoas.gerencia_pessoas.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.AddressRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.response.AddressResponseDto;
import com.gerencia_pessoas.gerencia_pessoas.service.AddressService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/address/v1")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PatchMapping("/person/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addNewAddressToPerson(@PathVariable UUID uuid,@Valid @RequestBody List<AddressRequestDto> addresses) {
        this.addressService.addNewAddressToPerson(uuid, addresses);
    }

    @PutMapping("/person/{uuid}/old-cep/{cep}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAddressByUuidAndCep(@PathVariable UUID uuid,@PathVariable String cep,@Valid @RequestBody AddressRequestDto newAddressRequestDto) {
        this.addressService.updateAddressByUuidAndCep(uuid, cep, newAddressRequestDto);
    }

    @PatchMapping("/person/{uuid}/new-principal-cep/{cep}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrincipalAddressToPersonByUuidAndCep(@PathVariable UUID uuid, @PathVariable String cep) {
        this.addressService.updatePrincipalAddressToPersonByUuidAndCep(uuid, cep);
    }

    @GetMapping("/person")
    public List<AddressResponseDto> getAllAddressByUuid(@RequestParam UUID uuid) {
        return this.addressService.getAllAddressByUuid(uuid);
    }

    @GetMapping("person/{uuid}/address/{cep}")
    public AddressResponseDto getAddressByUuidAndCep(@PathVariable UUID uuid, @PathVariable String cep) {
        return this.addressService.getAddressByUuidAndCep(uuid, cep);
    }
    

    
    


}
