import io.github.dmitriy1892.conventionplugins.project.extensions.commonMainDependencies

plugins {
    id("kmp.compose.library.plugin")
    id("kmp.coroutines.plugin")
    id("kmp.serialization.plugin")
    id("kmp.coil.plugin")
    id("kmp.ktor.plugin")
}

commonMainDependencies {
    implementation(libs.kotlinx.datetime)
}

android {
    namespace = "io.github.dmitriy1892.gradleconventionpuginssample.shared.uikit"
}

compose.resources {
    publicResClass = true
}
