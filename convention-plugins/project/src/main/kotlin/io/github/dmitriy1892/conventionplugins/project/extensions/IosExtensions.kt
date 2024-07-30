package io.github.dmitriy1892.conventionplugins.project.extensions

import io.github.dmitriy1892.conventionplugins.base.extensions.kotlinMultiplatformConfig
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

fun Project.iosRegularFramework(
    block: Framework.() -> Unit
) {
    kotlinMultiplatformConfig {
        targets
            .filterIsInstance<KotlinNativeTarget>()
            .forEach { nativeTarget -> nativeTarget.binaries.framework(configure = block) }
    }
}
