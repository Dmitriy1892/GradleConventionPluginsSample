pluginManagement {
    includeBuild("convention-plugins/base")
    includeBuild("convention-plugins/project")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}

rootProject.name = "GradleConventionPluginsSample"

include(":composeApp")
include(":shared-uikit")
