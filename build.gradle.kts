buildscript {
    val kotlinVersion = "1.4.31"
    extra["kotlinVersion"] = kotlinVersion
    extra["materialVersion"] = "1.3.0"

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks {
    create("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}