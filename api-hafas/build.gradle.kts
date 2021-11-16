plugins {
    `multiplatform-library`
    `api-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.serialization.core)
            }
        }
    }
}
