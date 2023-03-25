package com.person.swagger2;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/* spring.mvc.pathmatch.matching.strategy=ant-path-matcher*/
@Configurable
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		   return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .apis(RequestHandlerSelectors.basePackage("com.person.Controller"))
				   .paths(PathSelectors.any())
				   .build();
	}

}
