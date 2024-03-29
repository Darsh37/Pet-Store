package com.petstoreapp.petapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@EnableConfigurationProperties({FileStoragePropertie.class})
@SpringBootApplication
@EnableJpaAuditing
public class PetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetappApplication.class, args);	
		
	}

}
