import gradle.kotlin.dsl.accessors._ff1e04f882187441ad8eef90c6cec170.kotlin
import gradle.kotlin.dsl.accessors._ff1e04f882187441ad8eef90c6cec170.sourceSets
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.*

plugins {
    kotlin("multiplatform") apply false
}

val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED)
        exceptionFormat = TestExceptionFormat.FULL
    }
}

kotlin {
    sourceSets {
        val commonTest by getting {
            dependencies {
                api(project(":utils:utils-testing"))
            }
        }
    }
}