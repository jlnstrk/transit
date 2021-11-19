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
            }
        }
    }
}