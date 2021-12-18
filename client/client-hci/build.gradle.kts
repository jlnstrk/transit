import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    `client-library`
    alias(libs.plugins.buildkonfig)
    id("com.google.devtools.ksp") version "1.6.0-1.0.1"
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
                implementation(libs.serialization.json)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.encoding)
                implementation(libs.korlibs.krypto)
            }
            kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().all {
    if (name != "kspKotlinMetadata") {
        dependsOn("kspKotlinMetadata")
    }
}

dependencies {
    add("kspMetadata", project(":client:client-hci:model-sync"))
}