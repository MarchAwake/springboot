package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    /**
     * 配置 swagger2 核心配置 docket
     */
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)      // 指定 api 类型为 swagger2
                .apiInfo(apiInfo()) // 用于定义 api 文档汇总信息
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))  // 指定 controller 路径
                .paths(PathSelectors.any()) // 所有 controller
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .termsOfServiceUrl("http://www.demo.com")
                .title("demo")  // 文档页标题
                .contact(new Contact("demo", "http://www.demo.com", "master@demo.com"))   // 联系人信息
                .description("demo接口文档")    // 详细信息
                .version("1.0.0")   // 文档版本号
                .termsOfServiceUrl("http://www.demo.com")  // 网站地址
                .build();
    }
}
