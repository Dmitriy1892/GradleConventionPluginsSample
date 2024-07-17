import com.android.build.api.dsl.ManagedVirtualDevice
import io.github.dmitriy1892.conventionplugins.base.extensions.androidConfig
import io.github.dmitriy1892.conventionplugins.base.extensions.debugImplementation
import io.github.dmitriy1892.conventionplugins.base.extensions.implementation
import io.github.dmitriy1892.conventionplugins.base.extensions.kotlinAndroidTarget
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

kotlinAndroidTarget {
    instrumentedTestVariant {
        sourceSetTree.set(KotlinSourceSetTree.test)

        dependencies {
            debugImplementation(libs.androidx.testManifest)
            implementation(libs.androidx.junit4)
        }
    }
}

androidConfig {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    //https://developer.android.com/studio/test/gradle-managed-devices
    @Suppress("UnstableApiUsage")
    testOptions {
        managedDevices.devices {
            maybeCreate<ManagedVirtualDevice>("pixel5").apply {
                device = "Pixel 5"
                apiLevel = libs.versions.targetSdk.get().toInt()
                systemImageSource = "aosp"
            }
        }
    }
}
