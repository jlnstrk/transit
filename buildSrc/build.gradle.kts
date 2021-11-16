plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(libs.kotlinGradle)
    implementation(libs.dokkaGradle)
    implementation(libs.serializationGradle)
    implementation(libs.kotestGradle)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}