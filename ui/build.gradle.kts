plugins {
    id("com.android.library")

    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.ui"
    compileSdk = 30
    defaultConfig {
        minSdk = 22
    }

    buildFeatures {
        viewBinding = true
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
    implementation(project(":model"))
    implementation(project(":presentation"))

    implementation("androidx.core:core-ktx:1.6.0")

    kapt("androidx.lifecycle:lifecycle-compiler:$LIFECYCLE_VERSION")
    implementation("androidx.lifecycle:lifecycle-common-java8:$LIFECYCLE_VERSION")

    implementation("com.google.android.material:material:$MATERIAL_VERSION")

    val adapterDelegateVersion = "4.3.0"
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$adapterDelegateVersion")
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:$adapterDelegateVersion")

    val navVersion = "2.3.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.0-beta01")
}