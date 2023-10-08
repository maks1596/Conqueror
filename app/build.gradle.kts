plugins {
    id("com.android.application")

    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.conqueror"
    compileSdk = Android.COMPILE_SDK_VERSION
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.conqueror"
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
    implementation(project(":ui"))
    implementation(project(":presentation"))
    implementation(project(":presentation-impl"))
    implementation(project(":domain"))
    implementation(project(":domain-impl"))
    implementation(project(":data"))
    implementation(project(":data-impl"))

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")

    implementation("com.google.android.material:material:$MATERIAL_VERSION")

    val daggerVersion = "2.33"
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation("com.google.dagger:dagger-android:$daggerVersion")
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")

    kapt("androidx.lifecycle:lifecycle-compiler:$LIFECYCLE_VERSION")
    implementation("androidx.lifecycle:lifecycle-common-java8:$LIFECYCLE_VERSION")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION")
}