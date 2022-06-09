plugins {
    `client-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":utils:utils-core"))
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.serialization.json)
            }
        }
    }
}