import io.github.dmitriy1892.conventionplugins.base.extensions.debugImplementation
import io.github.dmitriy1892.conventionplugins.base.extensions.implementation
import io.github.dmitriy1892.conventionplugins.base.extensions.kotlinAndroidTarget
import io.github.dmitriy1892.conventionplugins.base.extensions.libs
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

kotlinAndroidTarget {
    instrumentedTestVariant {
        sourceSetTree.set(KotlinSourceSetTree.test)

        dependencies {
            debugImplementation(libs.androidx.testManifest)
            implementation(libs.androidx.junit4)
        }
    }
}
