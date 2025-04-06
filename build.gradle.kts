import com.github.gradle.node.npm.task.NpxTask

plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.github.node-gradle.node") version "7.1.0"
}

group = "io.github.chubbyhippo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["datafakerVersion"] = "2.4.2"
extra["alpinejsVersion"] = "3.14.3"
extra["nodeVersion"] = "22.14.0"

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    implementation("net.datafaker:datafaker:${property("datafakerVersion")}")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.webjars.npm:alpinejs:${property("alpinejsVersion")}")
    implementation("org.webjars:webjars-locator-core")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    getByName("main") {
        resources {
            exclude("static/css/application.css")
        }
    }
}

node {
    download.set(true)
    version.set("${property("nodeVersion")}")
    npmInstallCommand.set("ci")
}

tasks.register<NpxTask>("buildTailwind") {
    description = "Build tailwindcss"
    group = "build"
    dependsOn("npmInstall")
    command.set("tailwindcss")
    args.set(
        listOf(
            "-i",
            "./src/main/resources/static/css/application.css",
            "-o",
            "./build/resources/main/static/css/application.css",
        )
    )
}

tasks.getByName("compileJava").dependsOn("buildTailwind")
