plugins {
    id("kotlin")
}

java {
    sourceCompatibility = Kotlin.Java.SOURCE_COMPATIBILITY_VERSION
    targetCompatibility = Kotlin.Java.TARGET_COMPATIBILITY_VERSION
}

dependencies {
    api(project(":model"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_CORE_VERSION")
}