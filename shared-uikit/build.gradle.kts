import io.github.dmitriy1892.conventionplugins.base.extensions.androidMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonTestDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.iosMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.jvmMainDependencies

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)

    id("kmp.compose.config")
    id("android.base.test.config")
}

commonMainDependencies {
    implementation(libs.coil)
    implementation(libs.coil.network.ktor)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.ktor.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}

commonTestDependencies {
    implementation(libs.kotlinx.coroutines.test)
}

androidMainDependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.ktor.client.okhttp)
}

jvmMainDependencies {
    implementation(libs.kotlinx.coroutines.swing)
    implementation(libs.ktor.client.okhttp)
}

iosMainDependencies {
    implementation(libs.ktor.client.darwin)
}

android {
    namespace = "io.github.dmitriy1892.gradleconventionpuginssample.shared.uikit"
}

compose.resources {
    publicResClass = true
}
