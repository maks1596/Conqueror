plugins {
    id("kotlin")
}

java {
    sourceCompatibility = Kotlin.Java.SOURCE_COMPATIBILITY_VERSION
    targetCompatibility = Kotlin.Java.TARGET_COMPATIBILITY_VERSION
}

dependencies {
    implementation(project(":model"))
}