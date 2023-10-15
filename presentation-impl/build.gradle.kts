plugins {
    id("kotlin")
}

java {
    sourceCompatibility = Kotlin.Java.SOURCE_COMPATIBILITY_VERSION
    targetCompatibility = Kotlin.Java.TARGET_COMPATIBILITY_VERSION
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = Android.KotlinOptions.JVM_TARGET_VERSION
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":model"))
    implementation(project(":domain"))

    implementation(libs.kotlinx.coroutines.core)
}