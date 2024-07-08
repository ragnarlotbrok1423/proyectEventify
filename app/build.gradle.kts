plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.dev.eventify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dev.eventify"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    //Compose
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }

    //Compose
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    implementation(libs.androidx.room.ktx)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Compose
    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    // Material Design 3
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material3:material3-window-size-class")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.3.0-beta04")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // UI
    implementation("androidx.compose.ui:ui")
    // Animation
    implementation("androidx.compose.animation:animation")
    // Shapes
    implementation ("androidx.graphics:graphics-shapes:1.0.0-beta01")
    // Gif
    implementation("io.coil-kt:coil:2.6.0")
    implementation("io.coil-kt:coil-gif:2.6.0")
    implementation ("io.coil-kt:coil-compose:2.6.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.test:runner:1.6.1")
    androidTestImplementation("androidx.test:rules:1.6.1")
    // Image
    implementation("androidx.compose.foundation:foundation:1.6.8")

    // SplashScreen
    implementation("androidx.core:core-splashscreen:1.0.1")

    //  Activities
    implementation("androidx.activity:activity-compose")
    //  ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
    //  LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
    //  RxJava
    implementation("androidx.compose.runtime:runtime-rxjava2")

    // Mysql
    implementation ("mysql:mysql-connector-java:8.0.21")

    // Authentication
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("com.squareup.picasso:picasso:2.71828")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
//    >>>>>>> e809ea8c9d45a15491d6a664024c39cdcf5e981d
}