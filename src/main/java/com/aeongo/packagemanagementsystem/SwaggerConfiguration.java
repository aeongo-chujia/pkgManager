package com.aeongo.packagemanagementsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Package Management System")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aeongo.packagemanagementsystem.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo("Package Management System API", "Package Management System"));
    }


    private ApiInfo apiInfo(String title, String description) {
        Contact contact = new Contact("Zhaofeng Sun", "", "zhaofeng@aeongo.com");
        return new ApiInfo(title, description, "1.0", "terms of controller url",  contact, "license", "license url");
    }
}