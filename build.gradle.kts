buildscript {
    val kotlinVersion = "1.4.31"
    extra["kotlinVersion"] = kotlinVersion
    extra["materialVersion"] = "1.3.0"
    extra["coroutinesCoreVersion"] = "1.5.0"
    extra["lifecycleVersion"] = "2.3.1"

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
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