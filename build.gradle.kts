import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
	kotlin("plugin.allopen") version "1.4.32"
	kotlin("plugin.serialization") version "1.9.0"
}

group = "com.holme"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.postgresql:postgresql")
	implementation("com.h2database:h2")
	implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2") // JVM dependency
	implementation ("com.aallam.openai:openai-client:3.5.1") //* Open AI
	implementation("io.ktor:ktor-client-apache5:2.3.0") // Ktor
	implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // Coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3") // Coroutine
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootRun {
	val activeProfile: String = "dev"
	systemProperty("spring.profiles.active", activeProfile)
}