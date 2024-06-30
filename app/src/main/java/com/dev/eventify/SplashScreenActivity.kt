package com.example.eventify

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.views.SplashScreenView
import com.dev.eventify.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity: ComponentActivity() {

//    val splashScreen = installSplashScreen()

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
//                            splashScreen.setKeepOnScreenCondition {true}
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        },2000)

        }
    }


    fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

