plugins {
    `interop-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":common"))
                api(project(":client:client-efa"))
            }
        }
    }
}