import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    id("org.jetbrains.dokka")
    `maven-publish`
}

group = rootProject.properties["group"] as String
version = rootProject.properties["version"] as String

val isRelease get() = !version.toString().endsWith("SNAPSHOT")

tasks.named<DokkaTaskPartial>("dokkaHtmlPartial")
    .configure {
        dokkaSourceSets {
            configureEach {
                reportUndocumented.set(true)
            }
        }
    }

publishing {
    repositories {
        mavenLocal()
        maven {
            val snapshotRepositoryUrl: String by project
            val releaseRepositoryUrl: String by project
            url = uri(if (isRelease) releaseRepositoryUrl else snapshotRepositoryUrl)

            val repositoryUsername: String? by project
            val repositoryPassword: String? by project
            credentials {
                username = repositoryUsername.orEmpty()
                password = repositoryPassword.orEmpty()
            }
        }
    }
}