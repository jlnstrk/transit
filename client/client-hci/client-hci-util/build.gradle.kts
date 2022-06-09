plugins {
    `client-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":utils:utils-core"))
                api(project(":client:client-hafas"))
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }
}