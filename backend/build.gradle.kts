plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.climbingtrainer"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
}

// Copy frontend build into backend resources/static
tasks.register<Copy>("copyFrontend") {
    dependsOn(":frontend:npmBuild")
    from("${project(":frontend").projectDir}/dist")
    into("${layout.buildDirectory.get()}/resources/main/static")
}

tasks.named("processResources") {
    dependsOn("copyFrontend")
}
