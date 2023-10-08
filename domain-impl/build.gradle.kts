plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    api(project(":domain"))
    api(project(":data"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_CORE_VERSION")
}