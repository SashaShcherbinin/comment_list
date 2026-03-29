import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    alias(libs.plugins.service.firebase.crashlytics)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
}

object Version {
    private const val MAJOR = 1
    private const val MINOR = 0
    private const val PATCH = 0
    const val CODE = MAJOR * 10000 + MINOR * 100 + PATCH
    const val NAME = "$MAJOR.$MINOR.$PATCH"
}

android {
    namespace = "app"
    defaultConfig {
        applicationId = "start.mvi"
        targetSdk = 36
        compileSdk = 36
        minSdk = 23
        versionCode = Version.CODE
        versionName = Version.NAME
    }
    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.base.logger)
    implementation(projects.base.network)
    implementation(projects.base.storage)
    implementation(projects.base.compose)
    implementation(projects.base.database)
    implementation(projects.core)

    implementation(libs.bundles.koin.android)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.network)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.compose.image.loading.coil)
    implementation(libs.di.koin.android)
    implementation(libs.di.koin.compose)
    implementation(libs.kotlin.serialization.json)

    debugImplementation(libs.compose.tooling)
}
