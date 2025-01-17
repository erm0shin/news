package ru.bmstu.iu6.news

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux


@Configuration
@EnableSwagger2WebFlux
class SpringFoxConfig {
    @Bean
    fun apiDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    fun getApiInfo() = ApiInfo(
            "TITLE",
            "DESCIPRION",
            "VERSION",
            "TERMS OF SERVICE URL",
            Contact("NAME", "URL", "EMAIL"),
            "LICENSE",
            "LICENSE URL",
            emptyList()
    )

}