package com.gerencia_pessoas.gerencia_pessoas.utils;

public class CepUtils {
    public static String formatCep(String cep){
        return cep.replaceAll("[^0-9]", "");
    }
    public static Boolean isValidCep(String cep){
        return formatCep(cep).length() == 8;
    }
}
