package com.store.configure

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder


@Configuration
class JacksonConfiguration {

    @Bean
    fun objectMapper(builder: Jackson2ObjectMapperBuilder): ObjectMapper {
        val objectMapper = builder.build<ObjectMapper>()
        objectMapper.registerModule(JavaTimeModule())
        objectMapper.registerModule(KotlinModule(nullisSameAsDefault = true))
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        return objectMapper
    }
}
