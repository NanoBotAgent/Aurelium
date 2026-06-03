plugins {
    java
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public")
    maven("https://repo.extendedclip.com/content/repositories/placeholder/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("projectVersion": project.version)
        }
    }
}
