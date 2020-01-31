import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.2.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
	kotlin("plugin.jpa") version "1.3.61"
	kotlin("plugin.allopen") version "1.3.61"
	kotlin("plugin.noarg") version "1.3.61"
	kotlin("kapt") version "1.3.61"
}

group = "com.store"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
		exclude(module = "hibernate-core")
	}
	implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot.experimental:spring-boot-starter-data-r2dbc")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.springframework.boot.experimental:spring-boot-test-autoconfigure-r2dbc")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")

	implementation("io.jsonwebtoken:jjwt-api:0.10.7")
	implementation("io.jsonwebtoken:jjwt-impl:0.10.7")
	implementation("io.jsonwebtoken:jjwt-jackson:0.10.7")

	implementation("org.hibernate:hibernate-core:5.4.9.Final")
	implementation("com.querydsl:querydsl-jpa:4.2.2")
	implementation("org.flywaydb:flyway-core:6.1.1")
	runtimeOnly("mysql:mysql-connector-java")
	implementation("dev.miku:r2dbc-mysql:0.8.1.RELEASE")

	api("org.slf4j:slf4j-api:1.7.26")
	api("ch.qos.logback:logback-classic:1.2.3")
	api("ch.qos.logback:logback-core:1.2.3")
	api("ch.qos.logback.contrib:logback-jackson:0.1.5")
	api("ch.qos.logback.contrib:logback-json-classic:0.1.5")
	api("net.logstash.logback:logstash-logback-encoder:6.3")

	api("io.springfox:springfox-swagger2:2.9.2") {
		exclude(group = "io.swagger", module = "swagger-annotations")
		exclude(group="io.swagger", module = "swagger-models")
	}
	api("io.springfox:springfox-swagger-ui:2.9.2")

	api("io.swagger:swagger-annotations:1.5.21")
	api("io.swagger:swagger-models:1.5.21")

	api("org.mapstruct:mapstruct:1.3.1.Final")

	kapt("org.mapstruct:mapstruct-processor:1.3.1.Final")
	kapt("com.querydsl:querydsl-apt:4.2.2:jpa")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:0.1.0.M2")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}
