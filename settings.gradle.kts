pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Lab2_BusinessCard_NguyenKhoa"
include(":lab2_businesscard")
include(":Lab3_dice_roller")
include(":lab4_tiptime")
include(":lab5_woof")
include(":lab6")
include(":chuyentrang")
include(":lab7_firebase_courses")
