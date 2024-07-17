plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

kotlin {
    androidTarget()

    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()
}
