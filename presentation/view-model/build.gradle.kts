plugins {
    id("com.android.library")

    kotlin("android")
}

android {
    namespace = "com.example.viewModel"
    compileSdk = Android.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = Android.MIN_SDK_VERSION
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
    implementation(project(":model"))
    implementation(project(":domain"))

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
}