import com.android.build.api.dsl.ManagedVirtualDevice
import io.github.dmitriy1892.conventionplugins.base.extensions.androidConfig
import io.github.dmitriy1892.conventionplugins.base.extensions.libs

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
