package com.prayas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;

/*
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
*/


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Bean
  public Docket authAPI() {

    return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prayas"))
                .paths(PathSelectors.any())
                .build();

  }

}

