import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    `multiplatform-library`
    `api-library`
    `published-library`
    `tested-library`
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
    packageName = "de.jlnstrk.transit.api.hapi"

    defaultConfigs {
        buildConfigNullableField(STRING, "RMV_AID", rootProject.extra.getOrNull("hapi.rmv.aid"))
        buildConfigNullableField(STRING, "VBB_AID", rootProject.extra.getOrNull("hapi.vbb.aid"))
    }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":utils"))
                api(project(":api-hafas"))
                implementation(libs.serialization.json)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.encoding)
                implementation(libs.korlibs.krypto)
            }
        }
    }
}