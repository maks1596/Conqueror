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
include(":app", ":ui", ":presentation", ":presentation-impl", ":model")
include(":data")
include(":data-impl")
include(":domain")
include(":domain-impl")
