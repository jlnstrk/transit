plugins {
    `client-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":utils:utils-core"))
                implementation(libs.kotlinx.serialization.xml)
            }
        }
    }
}