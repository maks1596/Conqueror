import org.gradle.api.JavaVersion

object Android {
    const val COMPILE_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 22

    object CompileOptions {
        val SOURCE_COMPATIBILITY_VERSION = JavaVersion.VERSION_17
        val TARGET_COMPATIBILITY_VERSION = SOURCE_COMPATIBILITY_VERSION
    }

    object KotlinOptions {
        const val JVM_TARGET_VERSION = "17"
    }
}

object Kotlin {
    object Java {
        val SOURCE_COMPATIBILITY_VERSION = JavaVersion.VERSION_17
        val TARGET_COMPATIBILITY_VERSION = SOURCE_COMPATIBILITY_VERSION
    }
}