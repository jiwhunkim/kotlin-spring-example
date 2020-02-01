package com.store

import com.store.configure.CustomBeanNameGenerator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = ["com.store.repository.reactive"])
@EnableJpaRepositories(basePackages = ["com.store.repository.jpa"])
@ComponentScan(nameGenerator = CustomBeanNameGenerator::class)

class StoreApplication

fun main(args: Array<String>) {
	runApplication<StoreApplication>(*args)
}
