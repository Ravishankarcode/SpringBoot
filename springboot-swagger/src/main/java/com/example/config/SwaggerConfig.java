package com.example.config;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket postAPI(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-API").apiInfo(apiInfo()).select().paths(postPath()).build();
	}

	private Predicate<String> postPath(){
		return or(regex("/api/posts.*"), regex("/api/getValue.*"));
	}
	private ApiInfo apiInfo(){
		
		return new ApiInfoBuilder().title("Test Swagger").description("All Api in Test Swagger").build();
	}
}
