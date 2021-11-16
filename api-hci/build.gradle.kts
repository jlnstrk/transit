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
    packageName = "de.jlnstrk.transit.api.hci"

    defaultConfigs {
        buildConfigNullableField(STRING, "BVG_AID", rootProject.extra.getOrNull("hci.bvg.aid"))
        buildConfigNullableField(STRING, "HVV_AID", rootProject.extra.getOrNull("hci.hvv.aid"))
        buildConfigNullableField(STRING, "HVV_SALT", rootProject.extra.getOrNull("hci.hvv.salt"))
        buildConfigNullableField(STRING, "RMV_AID", rootProject.extra.getOrNull("hci.rmv.aid"))
        buildConfigNullableField(STRING, "SBM_AID", rootProject.extra.getOrNull("hci.sbm.aid"))
        buildConfigNullableField(STRING, "SBM_SALT", rootProject.extra.getOrNull("hci.sbm.salt"))
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