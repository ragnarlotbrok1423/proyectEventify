package com.dev.eventify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.views.OnboardingScreenView

@SuppressLint("CustomSplashScreen")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        // true asi que el activity mueve al otro activity
        setContent{
            EventifyTheme(darkTheme = false) {
                Surface(
                    modifier= Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    OnboardingScreenView()
//                    LoginScreenView()
//                    RegisterScreenView()
                }
            }

        }
    }
}
