plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.devtools.ksp")
    id ("dagger.hilt.android.plugin")

}
apply("../shared-dependencies.gradle")

android {
    namespace = "com.zanoafnan.favorite"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility (JavaVersion.VERSION_17)
                targetCompatibility (JavaVersion.VERSION_17)
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            /*proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )*/
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":core"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //androidTestImplementation("androidx.annotation:annotation:1.7.0")

    implementation ("com.google.dagger:hilt-android:2.43.2")
    ksp ("com.google.dagger:hilt-android-compiler:2.36")
    ksp("androidx.room:room-compiler:2.5.2")

    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    //implementation ("io.insert-koin:koin-android:3.2.0")
    //implementation ("io.insert-koin:koin-android-viewmodel:3.2.0")

    implementation ("io.insert-koin:koin-core:2.1.6")
    implementation ("io.insert-koin:koin-android:2.1.6")
    implementation ("io.insert-koin:koin-androidx-viewmodel:2.1.6")
}