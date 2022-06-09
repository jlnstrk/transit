plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.6.21-1.0.5")
    implementation("com.github.javaparser:javaparser-core:3.24.2")
    val kotlinPoetVersion = "1.11.0"
    implementation("com.squareup:kotlinpoet:$kotlinPoetVersion")
    implementation("com.squareup:kotlinpoet-ksp:$kotlinPoetVersion")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing-ksp:1.4.8")
    implementation(project(":client:client-hci:client-hci-util"))
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)
}