import io.github.dmitriy1892.conventionplugins.base.extensions.androidConfig
import io.github.dmitriy1892.conventionplugins.base.extensions.kotlinJvmCompilerOptions
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import io.github.dmitriy1892.conventionplugins.base.extensions.projectJavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

androidConfig {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

kotlinJvmCompilerOptions {
    jvmTarget.set(JvmTarget.fromTarget(projectJavaVersion.toString()))
    freeCompilerArgs.add("-Xjdk-release=${projectJavaVersion}")
}
