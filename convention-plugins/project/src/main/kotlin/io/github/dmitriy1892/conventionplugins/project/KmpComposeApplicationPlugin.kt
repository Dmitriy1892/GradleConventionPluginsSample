package io.github.dmitriy1892.conventionplugins.project

import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpComposeApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("android.application.plugin")
                apply("kmp.compose.config")
                apply("kmp.base.test.config")
            }
        }
    }

}
