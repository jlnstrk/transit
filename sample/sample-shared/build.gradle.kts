import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.buildkonfig)
}

buildscript {
    dependencies {
        classpath(libs.buildkonfigGradle)
    }
}

project.buildkonfig {
    packageName = "de.jlnstrk.transit.sample"

    defaultConfigs {
        buildConfigNullableField(STRING, "BVG_AID", rootProject.extra.getOrNull("hci.bvg.aid"))
    }
}

kotlin {
    jvm()

    ios {
        binaries {
            framework {
                baseName = "Transit"
            }
        }
    }
    js(IR).browser()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":interop:interop-hci"))
                api(project(":interop:interop-hapi"))
                api(project(":interop:interop-efa"))
                api(project(":interop:interop-trias"))
            }
        }
        val jvmMain by getting {
            // No Ktor client here, done in sample-android to use the android one
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.client.js)
            }
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>(targetName).binaries.getFramework(
            mode
        )
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks/$mode/$sdkName")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)