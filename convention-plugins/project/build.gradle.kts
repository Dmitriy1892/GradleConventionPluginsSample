import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "io.github.dmitriy1892.conventionplugins"

dependencies {
    implementation(libs.gradleplugin.android)
    implementation(libs.gradleplugin.kotlin)
    implementation(libs.gradleplugin.compose)
    implementation(libs.gradleplugin.composeCompiler)
    // Workaround for version catalog working inside precompiled scripts
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.gradleplugin.base)
}

private val projectJavaVersion: JavaVersion = JavaVersion.toVersion(libs.versions.javaConvention.get())

java {
    sourceCompatibility = projectJavaVersion
    targetCompatibility = projectJavaVersion
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.fromTarget(projectJavaVersion.toString()))
}

gradlePlugin {
    plugins {
        register("android.application.plugin") {
            id = "android.application.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.AndroidApplicationPlugin"
        }

        register("android.library.plugin") {
            id = "android.library.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.AndroidLibraryPlugin"
        }

        register("kmp.compose.application.plugin") {
            id = "kmp.compose.application.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.KmpComposeApplicationPlugin"
        }

        register("kmp.compose.library.plugin") {
            id = "kmp.compose.library.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.KmpComposeLibraryPlugin"
        }

        register("kmp.coroutines.plugin") {
            id = "kmp.coroutines.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.KmpCoroutinesPlugin"
        }

        register("kmp.serialization.plugin") {
            id = "kmp.serialization.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.KmpSerializationPlugin"
        }

        register("kmp.coil.plugin") {
            id = "kmp.coil.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.KmpCoilPlugin"
        }

        register("kmp.ktor.plugin") {
            id = "kmp.ktor.plugin"
            implementationClass = "io.github.dmitriy1892.conventionplugins.project.KmpKtorPlugin"
        }
    }
}