package com.zaknein.PokedexApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApiApplication.class, args);
	}

}

// duplicar implementaciones
// renombrarlas a repository
// de los repositorios quitar inyeccion de services
// de los services inyectar solo los repositorys