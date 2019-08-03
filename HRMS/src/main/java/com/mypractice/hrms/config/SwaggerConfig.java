package com.mypractice.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Nasruddin khan
 * SwaggerConfig.java
 * Mar 12, 2019 
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.mypractice.hrms.model")
public class SwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                        .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        String description = "HRMS it's help to create and manage the organization data";
        return new ApiInfoBuilder()
                .title("HRMS")
                .description(description)
                .termsOfServiceUrl("GIT")
                .license("JSOFT India")
                .licenseUrl("http://jsoftindia.com/")
                .version("1.0")
                .build();
    }
	
}
