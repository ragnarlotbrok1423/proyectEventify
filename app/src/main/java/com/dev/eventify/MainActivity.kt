package com.dev.eventify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dev.eventify.navigation.NavigationRoutes
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.views.unauthenticated.OnboardingScreenView

@SuppressLint("CustomSplashScreen")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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