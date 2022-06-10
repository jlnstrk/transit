plugins {
    `multiplatform-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.korlibs.klock)
                api(libs.kotlinx.datetime)
            }
        }
    }
}