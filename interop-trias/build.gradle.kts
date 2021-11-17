plugins {
    `multiplatform-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":common"))
                api(project(":api-trias"))
            }
        }
    }
}