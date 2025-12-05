# JVM Ergonomics Experiments

This project demonstrates JVM ergonomic behavior across different Java versions and container configurations.

## Branch Variations

### main
The primary configuration running Java 17 with moderate CPU constraints. This serves as the baseline for comparing other variations.

**Key characteristics:**
- Base image: `azul/zulu-openjdk-alpine:17-latest`
- Docker constraints: 4792MB memory, 2.0 CPUs
- Standard container-aware JVM behavior

### old-jvm-without-ergonomic-support
Uses an old JVM (OpenJDK 8u102) that lacks container awareness. The JVM cannot detect Docker container resource limits and incorrectly identifies the host system's resources instead of container constraints.

**Key characteristics:**
- Base image: `openjdk:8u102-jre`
- Java 8 without container support
- JVM ergonomics ignore Docker memory/CPU limits

### selecting-0.5-cpu
Modern JVM (Java 17) with container support, testing with fractional CPU allocation. Demonstrates how the JVM properly detects and respects Docker's `--cpus="0.5"` limit.

**Key characteristics:**
- Base image: `azul/zulu-openjdk-alpine:17-latest`
- Docker constraints: 4792MB memory, 0.5 CPUs
- JVM ergonomics correctly recognize container limits

### docker-with-constraints
Modern JVM (Java 17) with standard multi-core container constraints. Shows proper JVM behavior with typical resource limits.

**Key characteristics:**
- Base image: `azul/zulu-openjdk-alpine:17-latest`
- Docker constraints: 4792MB memory, 4.0 CPUs
- Full container awareness

### jvm17-without-docker-params
Modern JVM (Java 17) running without explicit Docker resource constraints. Demonstrates baseline JVM behavior when container limits are not specified.

**Key characteristics:**
- Base image: `azul/zulu-openjdk-alpine:17-latest`
- No Docker memory/CPU constraints
- JVM uses default ergonomics

## Running the Experiments

Each directory contains a `build-run.sh` script:

```bash
cd <directory-name>/jvm-ergonomics
./build-run.sh
```

The application outputs:
- Available processors detected by JVM
- Total physical RAM visible to JVM
- JVM memory settings (total, max, free)
