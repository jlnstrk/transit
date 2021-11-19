plugins {
    kotlin("js")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
        useCommonJs()
    }
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    implementation(project(":sample:sample-shared"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
}