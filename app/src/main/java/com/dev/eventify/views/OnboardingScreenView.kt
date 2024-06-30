package com.example.eventify.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eventify.R
import com.example.eventify.components.CustomContextText
import com.example.eventify.components.GradientButton
import com.example.eventify.components.GradientTitleText
import com.example.eventify.components.MediumSpace
import com.example.eventify.components.OutlineButton
import com.example.eventify.components.SmallSpace
import com.example.eventify.ui.themes.EventifyTheme
import com.example.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.example.eventify.ui.themes.GRA_VER_PURPLE_WHITE

@Composable
fun OnboardingScreenView(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        ) {
        Image(
            painter = painterResource(id = R.drawable.onboar_screen_bg),
            contentDescription = "Onboarding background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier.width(dimensionResource(id = R.dimen.app_width)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {

            GradientTitleText(text = stringResource(R.string.app_name),
                    gradient = GRA_VER_PURPLE_WHITE
            )

            SmallSpace()

            CustomContextText(text = stringResource(R.string.onboard_screen_text),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )

            Column(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.app_width))
                    .absolutePadding(0.dp, 50.dp, 0.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                GradientButton(
                        text = stringResource(R.string.action_login),
                        gradient = GRA_HOR_BLACK_PURPLE,
                    )

                MediumSpace()

                OutlineButton(
                        text = stringResource(R.string.action_register),
                    )
                }
        }

        

        }

}

@Preview
@Composable
fun OnboarPreview(){
    EventifyTheme(){
        OnboardingScreenView()
    }
}