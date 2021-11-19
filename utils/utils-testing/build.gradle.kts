plugins {
    `multiplatform-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotest.assertions.core)
                api(libs.kotest.framework.engine)
            }
        }
        val jvmMain by getting {
            dependencies {
                api(kotlin("reflect"))
                api(libs.kotest.runner.junit5)
                api(libs.kotest.framework.datatest)
            }
        }
    }
}