enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "transit"

include(":utils")
include(":utils:utils-core")
include(":utils:utils-testing")
include(":common")

include(":client")
include(":client:client-hafas")
include(":client:client-hci")
include(":client:client-hapi")
include(":client:client-efa")
include(":client:client-trias")

include(":interop")
include(":interop:interop-hafas")
include(":interop:interop-hci")
include(":interop:interop-hapi")
include(":interop:interop-efa")
include(":interop:interop-trias")

include(":sample")
include(":sample:sample-shared")
include(":sample:sample-android")
include(":sample:sample-ios")
include(":sample:sample-js")

include(":client:client-hci:client-hci-codegen")
include(":client:client-hci:client-hci-compat")
include(":client:client-hci:client-hci-util")
include("client:client-hci:client-hci-model")
// include("client:client-hapi:client-hapi-model")