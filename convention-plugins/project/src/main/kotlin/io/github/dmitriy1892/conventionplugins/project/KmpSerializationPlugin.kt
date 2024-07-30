package io.github.dmitriy1892.conventionplugins.project

import io.github.dmitriy1892.conventionplugins.project.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpSerializationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.kotlinx.serialization.get().pluginId)
            }

            commonMainDependencies {
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }

}
