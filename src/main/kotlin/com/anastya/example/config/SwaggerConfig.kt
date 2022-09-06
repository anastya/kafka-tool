package com.anastya.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
open class SwaggerConfig {
    /**
     * Бин для конфигурации Swagger UI
     */
    @Bean
    open fun api(): Docket {
        val apiInfo = ApiInfo(
            "Kafka-tool API",
            """Спецификация API сервиса kafka-tool""",
            "1.0",
            ApiInfo.DEFAULT.termsOfServiceUrl,
            ApiInfo.DEFAULT.contact,
            ApiInfo.DEFAULT.license,
            ApiInfo.DEFAULT.licenseUrl,
            ApiInfo.DEFAULT.vendorExtensions
        )

        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.anastya.example.controller"))
            .paths(PathSelectors.any())
            .build()
    }
}
