plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.myprojects.mynewsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.myprojects.mynewsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    val paging_version = "3.3.4"

    implementation(libs.androidx.paging.runtime)

    // optional - Jetpack Compose integration
    implementation(libs.androidx.paging.compose)
    val nav_version = "2.8.4"

    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose)
    val kotlinx_version = "`1.3.9`"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$kotlinx_version")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    //Dagger - Hilt
//    implementation ("com.google.dagger:hilt-android:2.39")
    //May need okkhttp also

    // Dagger - Hilt
//    kapt ("com.google.dagger:hilt-android-compiler:2.39")
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    kapt ("androidx.hilt:hilt-compiler:1.0.0")
//    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation(libs.hilt.android.v2511)
    kapt(libs.hilt.android.compiler.v2511)
    implementation (libs.androidx.hilt.navigation.compose)
//    implementation (libs.androidx.hilt.lifecycle.viewmodel)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    // Coil
    implementation ("io.coil-kt:coil-compose:1.4.0")

    // system ui controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.17.0")

    // flow layout
    implementation ("com.google.accompanist:accompanist-flowlayout:0.24.4-alpha")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
