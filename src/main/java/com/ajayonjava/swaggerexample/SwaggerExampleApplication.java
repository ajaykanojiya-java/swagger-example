package com.ajayonjava.swaggerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SwaggerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerExampleApplication.class, args);
	}

	//below configuration tells swagger how to behave while apis documentation.
	//to access the API UI documentation hit http://localhost:8888/swagger-ui.html
	//to access API on REST client hit: http://localhost:8888/v2/api-docs
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))// consider only these path for documentation
				.apis(RequestHandlerSelectors.basePackage("com.ajayonjava"))//consider only this package as base package.
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo(){
		return new ApiInfo(
				"Contact Book API",
				"Simple API to understand swagger under ajayonjava project",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ajay Kanojiya","http://ajayonjava.com","kanojiyaajay22@gmail.com"),
				"API License",
				"http://ajayonjava.com",
				Collections.emptyList());
	}

}
