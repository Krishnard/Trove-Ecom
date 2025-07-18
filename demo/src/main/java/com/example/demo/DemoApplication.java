package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		Dotenv dotEnv =Dotenv.configure().load();
		
		dotEnv.entries().forEach(
				entry -> System.setProperty
						(entry.getKey(), entry.getValue())
		);
		
		
		SpringApplication.run(DemoApplication.class, args);
	}

}
