package com.dev.eventify.ui.views

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.eventify.MainActivity
import com.dev.eventify.R
import com.dev.eventify.ui.components.GifImage
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_VER_BLUE_PURPLE
import com.dev.eventify.ui.themes.GRA_VER_PURPLE_WHITE
import kotlinx.coroutines.delay

@Composable
fun SplashScreenView(){

    val context = LocalContext.current
    val delayTime: Long  = 2000

    // Create a launcher for starting the activity
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ){}
    LaunchedEffect(key1 = true) {
        delay(delayTime)
        val intent = Intent(context, MainActivity::class.java)
        launcher.launch(intent)
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(GRA_VER_BLUE_PURPLE),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        GifImage(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.app_icon_size)),
            R.drawable.splash_icon)


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = dimensionResource(R.dimen.title_offset))
        ){
            Column(
                modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                GradientTitleText(
                    text = stringResource(id = R.string.app_name),
                    gradient = GRA_VER_PURPLE_WHITE
                )
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    EventifyTheme {
        SplashScreenView()
    }
}