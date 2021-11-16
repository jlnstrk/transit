plugins {
    `multiplatform-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":interop"))
                api(project(":interop-hafas"))
                api(project(":api-hapi"))
            }
        }
    }
}