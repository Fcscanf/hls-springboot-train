package org.hand.train.springboot.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * <p>
 * encoding:UTF-8
 *
 * @author Fcant 13:44 2019/12/5
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * @author Fcant 16:44 2019/12/5
     */
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.hand.train.springboot.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 该套 API 说明，包含作者、简介、版本、host、服务URL
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot_HLS API RULE")
                .contact(new Contact("fcant","null","fcscanf@outlook.com"))
                .version("0.1")
                .termsOfServiceUrl("localhost:8080/swagger")
                .description("hls api")
                .build();
    }

}
