package com.store.configure

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Order(10)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig() : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.httpBasic().disable()
    }
}
