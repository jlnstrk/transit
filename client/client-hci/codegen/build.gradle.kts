plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.6.10-1.0.2")
    implementation("com.github.javaparser:javaparser-core:3.23.1")
    val kotlinPoetVersion = "1.10.2"
    implementation("com.squareup:kotlinpoet:$kotlinPoetVersion")
    implementation("com.squareup:kotlinpoet-ksp:$kotlinPoetVersion")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing-ksp:1.4.7")
    implementation(project(":client:client-hci:util"))
    implementation(libs.serialization.core)
    implementation(libs.serialization.json)
}