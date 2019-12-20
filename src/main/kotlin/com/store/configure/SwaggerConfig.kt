package com.store.configure

import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Pageable
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.security.Principal

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun productApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.store.controller"))
                .build()
                .apiInfo(this.metaInfo())
                .securityContexts(listOf(securityContext()))
                .securitySchemes(listOf(ApiKey("JWT", "Authorization", "header")))
                .ignoredParameterTypes(
                        Pageable::class.java,
                        Principal::class.java
                )
    }

    private fun metaInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("API")
                .description("README\n")
                .version("1.0")
                .build()
    }

    private fun securityContext(): SecurityContext {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/api/.*/admin/.*"))
                .build()
    }

    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOf(authorizationScope)
        return listOf(SecurityReference("JWT", authorizationScopes))
    }

}
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@ApiImplicitParams(
        ApiImplicitParam(name = "page", dataType = "int", paramType = "query", defaultValue = "0", value = "Results page you want to retrieve (0..N)"),
        ApiImplicitParam(name = "size", dataType = "int", paramType = "query", defaultValue = "20", value = "Number of records per page."),
        ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). "
        + "Default sort order is ascending. " + "Multiple sort criteria are supported.")
)
annotation class ApiPageable
