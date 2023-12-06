import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kt.lint.gradle)
    `maven-publish`
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "kmp-launchpad-compose"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.material3)
            implementation(libs.androidx.navigation.compose)
        }
        commonMain.dependencies {
            implementation(compose.animation)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.bottlerocketstudios.launchpadcompose"
    compileSdk = libs.versions.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()
    }
}

group = "com.github.bottlerocketstudios"
version = libs.versions.launchpad.compose.get()

publishing {
    publications {
        register<MavenPublication>("$name-release") {
            artifactId = name.lowercase()
            from(components["kotlin"])
        }
    }
}
