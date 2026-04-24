# Aurelium 26.1.x Build

This folder contains the Aurelium plugin source configured for **Paper 26.1.x** (calendar-based versioning).

## Build Requirements
- **Java 25** JDK (e.g., Zulu 25.0.2 or Adoptium 25+)
- **Maven 3.9+**

## Paper API
- **Group**: `io.papermc.paper`
- **Artifact**: `paper-api`
- **Version**: `[26.1.2.build,)` (resolves to latest build, e.g. `26.1.2.build.21-alpha`)
- **Repository**: `https://repo.papermc.io/repository/maven-public/`

## Build Command
```bash
set JAVA_HOME=<path-to-java25-jdk>
mvn clean package
```

The output JAR is `target/Aurelium-1.4.2-26.1.jar`.

## Notes
- `plugin.yml` sets `api-version: '26.1'`
- No source code changes were needed — the 1.21.x codebase compiles cleanly against Paper 26.1.x API
- One deprecation warning in `VaultEconomy.java` (Vault API, not Paper API)
