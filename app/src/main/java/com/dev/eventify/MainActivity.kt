package com.example.eventify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eventify.ui.themes.EventifyTheme
import com.example.eventify.views.LoginScreenView
import com.example.eventify.views.OnboardingScreenView
import com.example.eventify.views.PerfilView
import com.example.eventify.views.RegisterScreenView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // true asi que el activity mueve al otro activity
//        splashScreen.setKeepOnScreenCondition {true}
        setContent{
            EventifyTheme(darkTheme = false) {
                Surface(
//                    modifier= Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    OnboardingScreenView()
//                    LoginScreenView()
                    RegisterScreenView()
                }
            }

        }

        // true asi que el activity mueve al otro activity
//        splashScreen.setKeepOnScreenCondition {true}
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, AppActivity::class.java))
//            finish()
//        },2000)
    }
}
