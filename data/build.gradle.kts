plugins {
    id("kotlin")
    kotlin("kapt")
}

java {
    sourceCompatibility = Kotlin.Java.SOURCE_COMPATIBILITY_VERSION
    targetCompatibility = Kotlin.Java.TARGET_COMPATIBILITY_VERSION
}

dependencies {
    api(project(":model"))

    implementation(libs.kotlinx.coroutines.core)
}