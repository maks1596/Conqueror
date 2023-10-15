plugins {
    id("com.android.application")

    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "ru.conqueror.game"
    compileSdk = Android.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "ru.conqueror.game"
        minSdk = Android.MIN_SDK_VERSION
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }

    compileOptions {
        sourceCompatibility = Android.CompileOptions.SOURCE_COMPATIBILITY_VERSION
        targetCompatibility = Android.CompileOptions.TARGET_COMPATIBILITY_VERSION
    }

    kotlinOptions {
        jvmTarget = Android.KotlinOptions.JVM_TARGET_VERSION
    }
}

dependencies {
    implementation(project(":presentation:ui"))
    implementation(project(":presentation:view-model"))
    implementation(project(":domain"))
    implementation(project(":domain-impl"))
    implementation(project(":data"))
    implementation(project(":data-impl"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.material)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.dagger.android)
    kapt(libs.dagger.android.processor)

    kapt(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.androidx.lifecycle.runtime)
}