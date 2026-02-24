plugins {
	kotlin("jvm") version "2.1.0"              // ✅ updated
	kotlin("plugin.spring") version "2.1.0"    // ✅ updated
	id("org.springframework.boot") version "3.4.3"       // ✅ updated
	id("io.spring.dependency-management") version "1.1.7" // ✅ updated
}

group = "com.sonali"
version = "0.0.1-SNAPSHOT"
description = "Smart Task AI Agent"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}


val langchain4jVersion = "1.0.1"
val langchain4jSpringVersion = "1.0.1-beta6"

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-web")

	// Kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// LangChain4j Spring Boot Starter
	implementation("dev.langchain4j:langchain4j-spring-boot-starter:$langchain4jSpringVersion")

	// LangChain4j Core
	implementation("dev.langchain4j:langchain4j:$langchain4jVersion")

	// OpenAI Integration
	implementation("dev.langchain4j:langchain4j-open-ai-spring-boot-starter:$langchain4jSpringVersion")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}


kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}