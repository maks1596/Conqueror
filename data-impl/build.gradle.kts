plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.netology.data.impl"
    compileSdk = 30

    defaultConfig {
        minSdk = 22
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":data"))

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    api("androidx.datastore:datastore-preferences:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_CORE_VERSION")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3")
}