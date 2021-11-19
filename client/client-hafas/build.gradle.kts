plugins {
    `client-library`
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
