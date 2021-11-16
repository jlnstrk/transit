plugins {
    kotlin("multiplatform")
}

kotlin {
    // Targets
    jvm()
    js(IR) {
        browser()
        nodejs()
    }
    ios()

    // Explicit API
    explicitApi()
}