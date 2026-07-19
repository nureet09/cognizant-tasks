# Hands On 1: Spring Web Project Architecture Overview

## 1. Directory Breakdown
* **`src/main/java`**: The home for core source code classes (`SpringLearnApplication.java`), business service engines, and REST endpoints.
* **`src/main/resources`**: Stores application metadata properties (`application.properties` or `application.yml`) and static frontend UI assets.
* **`src/test/java`**: Holds automated integration profiling scripts and testing validation test runners.

## 2. Core Components and Annotations
* **`@SpringBootApplication`**: A crucial umbrella annotation that wraps three core tasks:
  1. `@SpringBootConfiguration`: Flags the class as a configuration source.
  2. `@EnableAutoConfiguration`: Instructs Spring Boot to automatically configure beans based on the libraries in the project's classpath.
  3. `@ComponentScan`: Searches for and registers components, controllers, and services within the package structure.

## 3. Build & Dependency Structure
* **`pom.xml`**: The central Project Object Model file for Maven. It lists parent definitions, properties, build steps, and core tracking modules like `spring-boot-starter-web` (to bring in Spring MVC and embedded Tomcat servers) and `spring-boot-devtools` (for fast restarts).