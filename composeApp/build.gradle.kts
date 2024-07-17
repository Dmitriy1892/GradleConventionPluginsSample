import io.github.dmitriy1892.conventionplugins.base.extensions.androidMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonTestDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.iosMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.iosRegularFramework
import io.github.dmitriy1892.conventionplugins.base.extensions.jvmMainDependencies
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinx.serialization)

    id("kmp.compose.config")
    id("android.base.test.config")
}

commonMainDependencies {
    implementation(project(":shared-uikit"))

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

iosRegularFramework {
    baseName = "ComposeApp"
    isStatic = true
}

android {
    namespace = "io.github.dmitriy1892.gradleconventionpuginssample"

    defaultConfig {
        targetSdk = libs.versions.targetSdk.get().toInt()

        applicationId = "io.github.dmitriy1892.gradleconventionpuginssample.androidApp"
        versionCode = 1
        versionName = "1.0.0"
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
