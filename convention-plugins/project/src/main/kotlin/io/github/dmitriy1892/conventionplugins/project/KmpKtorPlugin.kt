package io.github.dmitriy1892.conventionplugins.project

import io.github.dmitriy1892.conventionplugins.base.extensions.androidMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.iosMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.jvmMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpKtorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(libs.ktor.core)
            }

            androidMainDependencies {
                implementation(libs.ktor.client.okhttp)
            }

            jvmMainDependencies {
                implementation(libs.ktor.client.okhttp)
            }

            iosMainDependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }

}
