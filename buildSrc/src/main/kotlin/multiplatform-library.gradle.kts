import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
}

kotlin {
    // Targets
    jvm()
    js(IR) {
        browser()
        nodejs()
    }
    ios()

    // Explicit API
    explicitApi()
}