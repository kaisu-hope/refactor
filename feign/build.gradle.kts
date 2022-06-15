plugins {
    java
    `java-library`
    id("org.springframework.boot") version "2.7.0" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}
allprojects {
    group = "com.kaisu"
    version = "1.0.0"
    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        mavenCentral()
    }
}
subprojects {
    apply(null, "java", null)
    apply(null, "java-library", null)
    apply(null, "io.spring.dependency-management", null)
    ext {
        set("testcontainersVersion", "1.17.2")
        set("springCloudVersion", "2021.0.3")
        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(17))
            }
        }
        dependencyManagement {
            imports {
                mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:${ext.get("springCloudVersion")}")
            }
            dependencies {
                dependency("org.testcontainers:testcontainers:${ext.get("testcontainersVersion")}")
                dependency("org.testcontainers:postgresql:${ext.get("testcontainersVersion")}")
            }
        }
    }
}