// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        //classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:2.36")

        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.43.2")

        //classpath ("com.android.tools.build:gradle:4.2.1")
        //classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        //classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
    id("com.android.dynamic-feature") version "8.1.0" apply false
    id ("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("com.android.library") version "8.1.0" apply false
}



