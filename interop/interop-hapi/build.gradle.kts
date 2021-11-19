plugins {
    `interop-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":common"))
                api(project(":interop:interop-hafas"))
                api(project(":client:client-hapi"))
            }
        }
    }
}