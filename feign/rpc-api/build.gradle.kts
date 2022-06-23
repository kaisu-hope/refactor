dependencies {
    api(project(":domain"))
    api("org.springframework.cloud:spring-cloud-starter-openfeign") {
        configurations.all {
            resolutionStrategy {
                force("org.bouncycastle:bcprov-jdk15on:1.70")
                force("commons-io:commons-io:2.11.0")
            }
        }
    }
}