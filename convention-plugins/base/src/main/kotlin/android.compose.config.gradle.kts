import io.github.dmitriy1892.conventionplugins.base.extensions.androidConfig

plugins {
    id("android.base.config")
}

androidConfig {
    buildFeatures {
        //enables a Compose tooling support in the AndroidStudio
        compose = true
    }
}
