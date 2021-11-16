import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    repositories {
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime"
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        kotlinOptions.freeCompilerArgs += "-Xskip-prerelease-check"
    }
}

val secretsFile = File(rootDir, "secrets.properties")
if (secretsFile.exists()) {
    val secrets = java.util.Properties()
    secrets.load(secretsFile.inputStream())
    for((key, value) in secrets) {
        extra[key.toString()] = value
    }
}