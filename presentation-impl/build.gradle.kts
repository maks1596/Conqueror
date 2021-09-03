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
    implementation(project(":presentation"))
    implementation(project(":model"))
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCoreVersion")
}