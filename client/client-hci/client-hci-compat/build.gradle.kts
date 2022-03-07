plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
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

    arg("outPackageName", hciPackage)

    arg("dateType", "$sharedUtilPackage.LocalDate")
    arg("dateSerializerType", "$hciSerializerPackage.HciLocalDateSerializer")
    arg("timeType", "$hciUtilPackage.HciLocalTime")
    arg("timeSerializerType", "$hciSerializerPackage.HciLocalTimeSerializer.WithDayOffset")
    arg("dateTimeType", "$sharedUtilPackage.LocalDateTime")
    arg("dateTimeSerializerType", "$hciSerializerPackage.HciUnixTimeSerializer")
    arg("zoneOffsetType", "$sharedUtilPackage.ZoneOffset")
    arg("zoneOffsetSerializerType", "$hciSerializerPackage.HciZoneOffsetSerializer")
}

dependencies {
    ksp(project(":client:client-hci:client-hci-codegen"))
    implementation(project(":client:client-hci:client-hci-util"))
}