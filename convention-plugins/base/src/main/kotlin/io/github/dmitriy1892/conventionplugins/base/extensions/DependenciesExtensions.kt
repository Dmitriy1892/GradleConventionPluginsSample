package io.github.dmitriy1892.conventionplugins.base.extensions

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("implementation", dependency)
}

fun DependencyHandlerScope.debugImplementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("debugImplementation", dependency)
}
