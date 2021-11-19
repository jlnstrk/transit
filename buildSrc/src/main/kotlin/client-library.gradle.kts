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