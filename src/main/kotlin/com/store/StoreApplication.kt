package com.store

import com.store.configure.CustomBeanNameGenerator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator::class)

class StoreApplication

fun main(args: Array<String>) {
	runApplication<StoreApplication>(*args)
}
