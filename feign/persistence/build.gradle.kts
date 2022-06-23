dependencies {
    api(project(":domain"))
    compileOnly("org.mapstruct:mapstruct")
    annotationProcessor("org.mapstruct:mapstruct-processor")
    annotationProcessor("org.projectlombok:lombok")
    api("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core")
    compileOnly("org.projectlombok:lombok")
    api("cn.hutool:hutool-core")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
}