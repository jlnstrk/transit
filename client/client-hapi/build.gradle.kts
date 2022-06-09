import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    `client-library`
    alias(libs.plugins.buildkonfig)
}

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.buildkonfigGradle)
    }
}

project.buildkonfig {
    packageName = "de.jlnstrk.transit.client.hapi"

    defaultConfigs {
        buildConfigNullableField(STRING, "RMV_AID", rootProject.extra.getOrNull("hapi.rmv.aid"))
        buildConfigNullableField(STRING, "VBB_AID", rootProject.extra.getOrNull("hapi.vbb.aid"))
    }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":utils:utils-core"))
                api(project(":client:client-hafas"))
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.client.encoding)
                implementation(libs.korlibs.krypto)
            }
        }
    }
}