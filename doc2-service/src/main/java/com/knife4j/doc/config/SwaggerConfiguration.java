package com.knife4j.doc.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.*;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SwaggerConfiguration
 * <p>配置可放在功能模块通过配置文件动态配置减少代码量</p>
 * <p>@EnableSwagger2WebMvc注解适用于webmvc，需要webflux使用@EnableSwagger2WebFlux</p>
 * @author jmac
 * @since 2022-08-28
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {

    private final OpenApiExtensionResolver openApiExtensionResolver;


    public SwaggerConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    @Order(value = 1)
    public Docket docDocket() {
        return new Docket(DocumentationType.SWAGGER_2).
                pathMapping("/doc")
                .enable(true)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions("knife4j-doc2"))
                ;
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("Knife4j接口文档2")
                .description("Knife4j接口文档2")
                .termsOfServiceUrl("https://doc.xiaominfo2.com/")
                .contact(new Contact("jmac2",
                        "https://www.gfwlest2.com",
                        "hhwzyan2@163.com"))
                .version("1.0.0")
                .build();
    }

}
