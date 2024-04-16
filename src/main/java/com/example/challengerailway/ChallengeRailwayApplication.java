package com.example.challengerailway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "URL padrão do servidor")})
@SpringBootApplication
public class ChallengeRailwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeRailwayApplication.class, args);
	}

}
