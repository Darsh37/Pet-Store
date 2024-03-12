package com.petstoreapp.petapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;




@SpringBootApplication
@EnableJpaAuditing
public class PetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetappApplication.class, args);	
		
	}

}
