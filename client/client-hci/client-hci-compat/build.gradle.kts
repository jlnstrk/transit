plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.7.0-1.0.6"
}

kotlin {
    sourceSets {
        val main by getting {
            kotlin.srcDir("build/generated/ksp/main/kotlin")
        }
    }
}

ksp {
    val sharedUtilPackage = "de.jlnstrk.transit.util"
    val hciPackage = "de.jlnstrk.transit.client.hci"
    val hciUtilPackage = "$hciPackage.util"
    val hciSerializerPackage = "$hciPackage.serializer"

    arg("hciSrcDir", project.rootProject.projectDir.path + "/hci-versions/1.45")
    arg("outPackageName", hciPackage)

    arg("dateType", "kotlinx.datetime.LocalDate")
    arg("dateSerializerType", "$hciSerializerPackage.HciLocalDateSerializer")
    arg("timeType", "$hciUtilPackage.HciLocalTime")
    arg("timeSerializerType", "$hciSerializerPackage.HciLocalTimeSerializer.WithDayOffset")
    arg("dateTimeType", "kotlinx.datetime.LocalDateTime")
    arg("dateTimeSerializerType", "$hciSerializerPackage.HciUnixTimeSerializer")
    arg("zoneOffsetType", "kotlinx.datetime.UtcOffset")
    arg("zoneOffsetSerializerType", "$hciSerializerPackage.HciZoneOffsetSerializer")
}

dependencies {
    ksp(project(":client:client-hci:client-hci-codegen"))
    implementation(project(":client:client-hci:client-hci-util"))
}