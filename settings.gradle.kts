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
include(":utils-testing")
include(":common")

include(":api-hafas")
include(":interop-hafas")

include(":api-hci")
include(":interop-hci")

include(":api-hapi")
include(":interop-hapi")

include(":api-efa")
include(":interop-efa")

include(":api-trias")
include(":interop-trias")