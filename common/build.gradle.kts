plugins {
    `multiplatform-library`
    `serialization-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":utils:utils-core"))
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)
                // implementation(libs.serialization.xml)
            }
        }
    }
}