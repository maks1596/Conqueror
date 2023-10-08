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
    api(project(":domain"))
    api(project(":data"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_CORE_VERSION")
}