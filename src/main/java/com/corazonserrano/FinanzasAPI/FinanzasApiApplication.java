package com.corazonserrano.FinanzasAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@OpenAPIDefinition
//Nueva Linea
@EntityScan("com.corazonserrano.FinanzasAPI.model")
public class FinanzasApiApplication {

	public static void main(String[] args) {SpringApplication.run(FinanzasApiApplication.class, args);}
}
