plugins {
    id("com.android.library")

    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.ui"
    compileSdk = Android.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = Android.MIN_SDK_VERSION
    }

    buildFeatures {
        viewBinding = true
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
    implementation(project(":presentation"))

    implementation(libs.androidx.core.ktx)

    kapt(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.lifecycle.common)

    implementation(libs.material)

    implementation(libs.adapterdelegates4.kotlin.dsl)
    implementation(libs.adapterdelegates4.kotlin.dsl.viewbinding)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.viewbindingpropertydelegate.noreflection)
}