plugins {
    `multiplatform-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.korlibs.klock)
            }
        }
    }
}