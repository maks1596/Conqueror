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

const val KOTLIN_VERSION = "1.5.20"
const val MATERIAL_VERSION = "1.3.0"
const val COROUTINES_CORE_VERSION = "1.5.0"
const val LIFECYCLE_VERSION = "2.3.1"