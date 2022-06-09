plugins {
    `client-library`
    `published-library`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":client:client-hci:client-hci-util"))
                api(project(":utils:utils-core"))
                api(project(":client:client-hafas"))
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }
}

tasks.register<Delete>("cleanModel") {
    delete(fileTree(layout.projectDirectory.file("src/commonMain/kotlin")) {
        include("*/**")
    })
}

tasks.register<Copy>("importModelFromGeneratedCompat") {
    dependsOn(":client:client-hci:client-hci-compat:kspKotlin")
    dependsOn("cleanModel")
    from(
        project(":client:client-hci:client-hci-compat").buildDir
            .resolve("generated/ksp/main/kotlin")
    )
    include("**/*.kt")
    into(layout.projectDirectory.file("src/commonMain/kotlin"))
}