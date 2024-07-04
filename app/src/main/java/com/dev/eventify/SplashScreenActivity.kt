package com.dev.eventify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.views.SplashScreenView
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            EventifyTheme(darkTheme = false) {
                Surface(
                    modifier= Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreenView()

                }
            }

        }
    }

}

