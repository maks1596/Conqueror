buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION")
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