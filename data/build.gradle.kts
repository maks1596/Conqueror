plugins {
    id("kotlin")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(project(mapOf("path" to ":model")))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_CORE_VERSION")
}