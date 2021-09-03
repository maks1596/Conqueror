plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCoreVersion")
}