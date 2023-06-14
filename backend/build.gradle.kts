import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
  mavenCentral()
  maven("https://jitpack.io")
  maven("https://repo.spring.io/milestone")
  maven("https://repo.spring.io/snapshot")
}
plugins {
  id("org.springframework.boot") version "3.1.1-SNAPSHOT"
  id("io.spring.dependency-management") version "1.1.0"
  kotlin("jvm") version "1.8.22"
  kotlin("plugin.spring") version "1.8.22"
}
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("io.mockk:mockk:1.13.4")
}
tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "19"
  kotlinOptions.freeCompilerArgs += listOf("-Xjsr305=strict")
}
tasks.withType<JavaCompile> {
  sourceCompatibility = "19"
  targetCompatibility = "19"
}
tasks.test {
  useJUnitPlatform()
  jvmArgs("--enable-preview")
}
tasks.bootJar {
  archiveVersion.set("boot")
}
