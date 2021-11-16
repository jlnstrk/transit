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

include(":api-hafas")
include(":api-hci")
include(":api-hapi")
include(":api-efa")
include(":api-trias")
include(":interop")
include(":interop-hafas")
include(":interop-hci")
include(":interop-hapi")
include(":interop-efa")
include(":interop-trias")
include(":utils")
include(":utils-testing")
