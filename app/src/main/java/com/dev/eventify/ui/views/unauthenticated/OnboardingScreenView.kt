package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
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
import com.dev.eventify.R
import com.dev.eventify.ui.components.ContextText
import com.dev.eventify.ui.components.GradientButton
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.components.LargeSpace
import com.dev.eventify.ui.components.MediumSpace
import com.dev.eventify.ui.components.OutlineButton
import com.dev.eventify.ui.components.SmallSpace
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.GRA_VER_PURPLE_WHITE

@Composable
fun OnboardingScreenView(
    navigateToLogin: () -> Unit,
    navigateToRegistration: () -> Unit,
    navigateToAuthenticatedRoute: () -> Unit,
){
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

            ContextText(text = stringResource(R.string.onboard_screen_text),
                textAlign = TextAlign.Center,
            )

            LargeSpace()

            Column(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.app_width))
                    .absolutePadding(0.dp, 50.dp, 0.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                GradientButton(
                        text = stringResource(R.string.action_login),
                        gradient = GRA_HOR_BLACK_PURPLE,
                        onClick = {
                            navigateToLogin.invoke()
                        }
                    )

                MediumSpace()

                OutlineButton(
                        text = stringResource(R.string.action_register),
                        onClick = {
                            navigateToRegistration.invoke()
                        }
                    )
                }
        }

        

        }

}

@Preview
@Composable
fun OnboardPreview(){
    EventifyTheme(){
        OnboardingScreenView(
            navigateToLogin= {},
            navigateToRegistration= {},
            navigateToAuthenticatedRoute= {}
        )
    }
}