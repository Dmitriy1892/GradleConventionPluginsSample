package io.github.dmitriy1892.conventionplugins.base.extensions

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun Project.commonMainDependencies(block: KotlinDependencyHandler.() -> Unit) {
    kotlinMultiplatformConfig {
        sourceSets.commonMain.dependencies(block)
    }
}

fun Project.commonTestDependencies(block: KotlinDependencyHandler.() -> Unit) {
    kotlinMultiplatformConfig {
        sourceSets.commonTest.dependencies(block)
    }
}

fun Project.androidMainDependencies(block: KotlinDependencyHandler.() -> Unit) {
    kotlinMultiplatformConfig {
        sourceSets.androidMain.dependencies(block)
    }
}

fun Project.jvmMainDependencies(block: KotlinDependencyHandler.() -> Unit) {
    kotlinMultiplatformConfig {
        sourceSets.jvmMain.dependencies(block)
    }
}

fun Project.iosMainDependencies(block: KotlinDependencyHandler.() -> Unit) {
    kotlinMultiplatformConfig {
        sourceSets.iosMain.dependencies(block)
    }
}
