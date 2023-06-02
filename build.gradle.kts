import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	kotlin("plugin.jpa") version "1.8.21"
	kotlin("kapt") version "1.8.21"
}

group = "com.test"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-actuator")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// swagger-ui
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.0")

	implementation("commons-validator:commons-validator:1.7")

	// mapstruct
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")

	// lombok
	implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	compileOnly("org.projectlombok:lombok:1.18.24")

	// database
	runtimeOnly ("com.h2database:h2")
	runtimeOnly ("org.postgresql:postgresql")
}

kapt {
	arguments {
		arg("mapstruct.defaultComponentModel", "spring")
		arg("mapstruct.suppressGeneratorTimestamp","true")
		arg("mapstruct.suppressGeneratorVersionInfoComment","true")
		arg("mapstruct.verbose","true")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

