package com.dev.eventify

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.eventify.navigation.AppNavHost
import com.dev.eventify.ui.themes.EventifyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // muestra despues de splashscreen
        setContent{
            MainApp()
        }
    }
}

@Composable
private fun MainApp(){
    EventifyTheme(darkTheme = false) {
        Surface(
            modifier= Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavHost()
        }
    }
}

@Composable
@Preview
fun AppPrewview(){
    MainApp()
}