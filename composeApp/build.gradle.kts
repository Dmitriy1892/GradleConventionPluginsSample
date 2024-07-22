import io.github.dmitriy1892.conventionplugins.base.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.iosRegularFramework
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

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

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.github.dmitriy1892.gradleconventionpuginssample.desktopApp"
            packageVersion = "1.0.0"
        }
    }
}
