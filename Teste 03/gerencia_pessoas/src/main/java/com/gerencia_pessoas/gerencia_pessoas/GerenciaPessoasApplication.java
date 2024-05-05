package com.gerencia_pessoas.gerencia_pessoas;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GerenciaPessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciaPessoasApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }	

}
