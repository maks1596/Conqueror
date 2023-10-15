pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Conqueror"
include(":app")
include(":presentation:ui", ":presentation:view-model")
include(":model")
include(":data", ":data-impl")
include(":domain", ":domain-impl")
