package io.github.dmitriy1892.conventionplugins.project.extensions

import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.desktop.DesktopExtension
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

fun Project.composeDesktopApplication(
    mainClass: String,
    packageName: String,
    version: String = libs.versions.appVersionName.get(),
    targetFormats: List<TargetFormat> = listOf(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
) {
    extensions.getByType<ComposeExtension>().extensions.configure<DesktopExtension> {
        application {
            this.mainClass = mainClass

            nativeDistributions {
                targetFormats(*targetFormats.toTypedArray())
                this.packageName = packageName
                this.packageVersion = version
            }
        }
    }
}
