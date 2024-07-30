import io.github.dmitriy1892.conventionplugins.project.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.project.extensions.composeDesktopApplication
import io.github.dmitriy1892.conventionplugins.project.extensions.iosRegularFramework

plugins {
    id("kmp.compose.application.plugin")
    id("kmp.coroutines.plugin")
    id("kmp.serialization.plugin")
    id("kmp.coil.plugin")
    id("kmp.ktor.plugin")
}

commonMainDependencies {
    implementation(project(":shared-uikit"))
    implementation(libs.kotlinx.datetime)
}

iosRegularFramework {
    baseName = "ComposeApp"
    isStatic = true
}

android {
    namespace = "io.github.dmitriy1892.gradleconventionpuginssample"

    defaultConfig {
        applicationId = "io.github.dmitriy1892.gradleconventionpuginssample.androidApp"
    }
}

composeDesktopApplication(
    mainClass = "MainKt",
    packageName = "io.github.dmitriy1892.gradleconventionpuginssample.desktopApp"
)
