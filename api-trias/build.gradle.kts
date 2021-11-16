plugins {
    `multiplatform-library`
    `tested-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":utils"))
                implementation(libs.serialization.xml)
            }
        }
    }
}