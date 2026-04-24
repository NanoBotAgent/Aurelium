# Aurelium 26.2.x Build (Preview)

This folder contains the Aurelium plugin source configured for **Paper 26.2.x** (calendar-based versioning).

## Status: PREVIEW
Paper 26.2.x API artifacts are **not yet published** to the PaperMC Maven repository. This build currently compiles against the **26.1.x API** as a forward-compatible preview. When 26.2.x artifacts become available, update the `paper-api` version in `pom.xml` from `[26.1.2.build,)` to `[26.2.0.build,)` and rebuild.

## Build Requirements
- **Java 25** JDK (e.g., Zulu 25.0.2 or Adoptium 25+)
- **Maven 3.9+**

## Paper API
- **Group**: `io.papermc.paper`
- **Artifact**: `paper-api`
- **Version**: `[26.1.2.build,)` (fallback until 26.2.x is published)
- **Repository**: `https://repo.papermc.io/repository/maven-public/`

## Build Command
```bash
set JAVA_HOME=<path-to-java25-jdk>
mvn clean package
```

The output JAR is `target/Aurelium-1.4.2-26.2-SNAPSHOT.jar`.

## Notes
- `plugin.yml` sets `api-version: '26.2'`
- `pom.xml` version is `1.4.2-26.2-SNAPSHOT` to indicate preview status
- No source code changes were needed
- When 26.2.x API is released, change the dependency version in `pom.xml` and remove `-SNAPSHOT` from the project version
