buildscript {
    val kotlinVersion = "1.4.31"
    extra["kotlinVersion"] = kotlinVersion
    extra["materialVersion"] = "1.3.0"

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    create("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}