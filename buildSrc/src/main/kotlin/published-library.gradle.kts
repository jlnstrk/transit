import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    id("org.jetbrains.dokka")
    `maven-publish`
}

group = rootProject.properties["group"] as String
version = rootProject.properties["version"] as String

val isRelease get() = !version.toString().endsWith("SNAPSHOT")

tasks.named<DokkaTaskPartial>("dokkaHtmlPartial").configure {
    dokkaSourceSets {
        configureEach {
            reportUndocumented.set(true)
        }
    }
}

val javadocJar by tasks.registering(Jar::class) {
    val dokkaHtml = tasks.named<DokkaTask>("dokkaHtml")
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.get().outputDirectory)
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

    publications.withType<MavenPublication>().configureEach {
        artifact(javadocJar.get())

        val pomScmUrl: String? by project
        val pomUrl: String? by project
        val pomScmConnection: String? by project
        val pomLicenseName: String? by project
        val pomLicenseUrl: String? by project
        val pomLicenseDist: String? by project
        val pomDeveloperId: String? by project
        val pomDeveloperName: String? by project

        pom {
            url.set(pomUrl)
            licenses {
                license {
                    name.set(pomLicenseName)
                    url.set(pomLicenseUrl)
                    distribution.set(pomLicenseDist)
                }
            }
            developers {
                developer {
                    id.set(pomDeveloperId)
                    name.set(pomDeveloperName)
                }
            }
            scm {
                connection.set(pomScmConnection)
                url.set(pomScmUrl)
            }
        }
    }
}