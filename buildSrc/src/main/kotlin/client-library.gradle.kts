import org.gradle.kotlin.dsl.getting
import org.gradle.kotlin.dsl.the

plugins {
    id("multiplatform-library")
    id("serialization-library")
    id("tested-library")
    id("published-library")
}

val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                progressiveMode = true
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.client.logging)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.ktor.client.jvm)
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(libs.ktor.client.js)
            }
        }
        val iosX64Test by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
        val iosArm64Test by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
        val iosSimulatorArm64Test by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
    }
}