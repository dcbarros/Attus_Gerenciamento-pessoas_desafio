package com.gerencia_pessoas.gerencia_pessoas.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gerencia_pessoas.gerencia_pessoas.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

    @Query("""
        SELECT a FROM Address a 
        WHERE a.person.uuid = :uuid AND a.cep = :cep
    """)
    Optional<Address> findAddressByUuidAndCep(@Param("uuid") UUID uuid, @Param("cep") String cep);

    @Query("""
        SELECT (count(a) > 0) FROM Address a 
        WHERE a.person.id = :id AND a.cep = :cep
    """)
    Boolean existsAddressByPersonIdAndCep(@Param("id") Long personId, @Param("cep") String cep);

    @Query("""
        SELECT (count(a) > 0) FROM Address a 
        WHERE a.person.uuid = :uuid AND a.cep = :cep
    """)
    Boolean existsAddressByPersonUuidAndCep(@Param("uuid") UUID uuid, @Param("cep") String cep);

    @Query("""
        SELECT (count(a) > 0) FROM Address a 
        WHERE a.person.id = :id AND a.cep = :cep AND a.number = :number
    """)
    Boolean existsAddressByPersonIdAndCepAndNumber(@Param("id") Long personId, @Param("cep") String cep, @Param("number") Integer number);
    
    @Modifying
    @Query("""
        UPDATE  Address a 
        SET a.isPrincipal = false
        WHERE a.person.uuid = :uuid AND a.isPrincipal = true
    """)
    void changePrincipalAddressToFalse(@Param("uuid") UUID uuid);

    @Modifying
    @Query("""
        UPDATE  Address a 
        SET a.isPrincipal = true
        WHERE a.person.uuid = :uuid AND a.cep = :cep
    """)
    void modifyingPrincipalAddressByUuidAndCep(@Param("uuid") UUID uuid, @Param("cep") String cep);
}
