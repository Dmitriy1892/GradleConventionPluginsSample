package io.github.dmitriy1892.conventionplugins.project

import io.github.dmitriy1892.conventionplugins.base.extensions.androidMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.commonTestDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.jvmMainDependencies
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpCoroutinesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(libs.kotlinx.coroutines.core)
            }

            commonTestDependencies {
                implementation(libs.kotlinx.coroutines.test)
            }

            androidMainDependencies {
                implementation(libs.kotlinx.coroutines.android)
            }

            jvmMainDependencies {
                implementation(libs.kotlinx.coroutines.swing)
            }
        }
    }

}
