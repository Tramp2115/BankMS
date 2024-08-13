package com.lukas.cards;

import com.lukas.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties({CardsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "Lukas Cards microservice REST API Documentation",
				version="v1",
				contact = @Contact(
						name = "Lukas Augusewicz",
						email = "lukaszaugusewicz@gmail.com",
						url = "https://lukaszaugusewicz.com"
				),
				license =@License(
						name = "Apache 2.0",
						url = "https://lukaszaugusewicz.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Lukas Cards microservice REST API Documentation",
				url = "https://lukaszaugusewicz.com/swagger-ui.html#"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
