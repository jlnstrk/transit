import gradle.kotlin.dsl.accessors._ff1e04f882187441ad8eef90c6cec170.kotlin
import org.gradle.kotlin.dsl.kotlin

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