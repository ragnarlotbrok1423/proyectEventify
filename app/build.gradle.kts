plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.dev.eventify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dev.eventify"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.navigation:navigation-compose:2.5.3")
    implementation ("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.3.0-beta03")

    // Compose
    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    // Material Design 3
    implementation("androidx.compose.material3:material3")
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.6.0")//2.7.1

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
    implementation ("androidx.graphics:graphics-shapes:1.0.0-alpha05")
    // Gif
    implementation("io.coil-kt:coil:2.6.0")
    implementation("io.coil-kt:coil-gif:2.6.0")
    implementation ("io.coil-kt:coil-compose:2.6.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
    // Image
    implementation("androidx.compose.foundation:foundation:1.6.8")

    // SplashScreen
    implementation("androidx.core:core-splashscreen:1.0.1")

    //  Included automatically by material, icons but not the material library
    implementation("androidx.compose.material:material-icons-core")
    //  Add full set of material icons
    implementation("androidx.compose.material:material-icons-extended")
    //  Add window size utils
    implementation("androidx.compose.material3:material3-window-size-class")

    //  Integration with activities
    implementation("androidx.activity:activity-compose")
    //  Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
    //  Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
    //  Integration with RxJava
    implementation("androidx.compose.runtime:runtime-rxjava2")
}