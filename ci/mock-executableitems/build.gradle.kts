plugins {
    id("java")
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

group = "mock"
version = "1.0.0"

tasks.withType<JavaCompile> {
    options.encoding = Charsets.UTF_8.name()
    options.release.set(21)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public")
    maven("https://repo.extendedclip.com/content/repositories/placeholder/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))
