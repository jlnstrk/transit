plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    google()
}

dependencies {
    implementation(libs.kotlinGradle)
    implementation(libs.dokkaGradle)
    implementation(libs.serializationGradle)
    implementation(libs.kotestGradle)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation("com.android.tools.build:gradle:7.0.0")
}