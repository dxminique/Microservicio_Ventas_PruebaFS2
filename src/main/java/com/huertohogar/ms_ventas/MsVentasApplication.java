package com.huertohogar.ms_ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.huertohogar.ms_ventas.repository")
public class MsVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVentasApplication.class, args);
	}
}