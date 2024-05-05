package com.gerencia_pessoas.gerencia_pessoas.service;

import java.util.List;
import java.util.UUID;

import com.gerencia_pessoas.gerencia_pessoas.model.dto.request.AddressRequestDto;
import com.gerencia_pessoas.gerencia_pessoas.model.dto.response.AddressResponseDto;

public interface AddressService {
    void addNewAddressToPerson(UUID uuid, List<AddressRequestDto> addresses);
    void updateAddressByUuidAndCep(UUID uuid, String cep, AddressRequestDto newAddressRequestDto);
    List<AddressResponseDto> getAllAddressByUuid(UUID uuid);
    AddressResponseDto getAddressByUuidAndCep(UUID uuid, String cep);
    void updatePrincipalAddressToPersonByUuidAndCep(UUID uuid, String cep);
}
