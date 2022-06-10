import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompileCommon

plugins {
    id("org.jetbrains.dokka")
}

group = "de.jlnstrk"
version = "0.1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        mavenLocal()
    }
}

tasks.dokkaHtmlMultiModule.configure {
    outputDirectory.set(rootDir.resolve("docs/reference"))
}

val secretsFile = File(rootDir, "secrets.properties")
if (secretsFile.exists()) {
    val secrets = java.util.Properties()
    secrets.load(secretsFile.inputStream())
    for ((key, value) in secrets) {
        extra[key.toString()] = value
    }
}