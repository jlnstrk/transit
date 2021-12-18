import gradle.kotlin.dsl.accessors._fdfb5ffc67e3c13de6041b97417ec24f.kotlin
import gradle.kotlin.dsl.accessors._fdfb5ffc67e3c13de6041b97417ec24f.sourceSets
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
        val iosTest by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
    }
}