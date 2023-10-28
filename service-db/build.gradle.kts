import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.9.20-RC"
	kotlin("plugin.spring") version "1.9.20-RC"
	kotlin("plugin.jpa") version "1.9.20-RC"
}

group = "com.compress"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")
	implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
	developmentOnly("org.springframework.boot:spring-boot-devtools:3.0.4")
	runtimeOnly("com.h2database:h2:2.1.214")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
