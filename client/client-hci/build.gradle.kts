import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    `client-library`
    alias(libs.plugins.buildkonfig)
}

buildscript {
    dependencies {
        classpath(libs.buildkonfigGradle)
    }
}

project.buildkonfig {
    packageName = "de.jlnstrk.transit.client.hci"

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
                api(project(":utils:utils-core"))
                api(project(":client:client-hafas"))
                api(project(":client:client-hci:client-hci-model"))
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.client.encoding)
                implementation(libs.korlibs.krypto)
            }
        }
    }
}