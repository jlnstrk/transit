plugins {
    `multiplatform-library`
    `api-library`
    `tested-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":utils"))
                implementation(libs.serialization.json)
                implementation(libs.ktor.client.serialization)
            }
        }
    }
}