package io.github.dmitriy1892.conventionplugins.project

import io.github.dmitriy1892.conventionplugins.base.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpCoilPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(libs.coil)
                implementation(libs.coil.network.ktor)
            }
        }
    }

}
