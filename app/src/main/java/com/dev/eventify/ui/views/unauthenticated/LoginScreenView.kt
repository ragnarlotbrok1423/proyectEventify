package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.eventify.R
import com.dev.eventify.data.state.login.LoginUiEvent
import com.dev.eventify.ui.components.ContextText
import com.dev.eventify.ui.components.GapColumn
import com.dev.eventify.ui.components.GradientButton
import com.dev.eventify.ui.components.GradientPasswordField
import com.dev.eventify.ui.components.GradientTextField
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.components.IconBackButton
import com.dev.eventify.ui.components.ImageMaxWidth
import com.dev.eventify.ui.components.LargeSpace
import com.dev.eventify.ui.components.MediumSpace
import com.dev.eventify.ui.components.NavigationText
import com.dev.eventify.ui.components.ScrollableColumn
import com.dev.eventify.ui.components.SubTitleText
import com.dev.eventify.ui.components.TopStartColumn
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.GRA_VER_BLACK_PURPLE
import com.dev.eventify.ui.themes.md_theme_light_onPrimary
import com.dev.eventify.ui.themes.md_theme_light_onPrimaryContainer
import com.dev.eventify.ui.viewModels.unauthenticated.LoginViewModel

@Composable
fun LoginScreenView(
    loginViewModel: LoginViewModel = viewModel(),
    navigateToRegistration: () -> Unit,
    navigateToForgotPassword: () -> Unit,
    navigateToAuthenticatedRoute: () -> Unit,
    navigateBack: () -> Unit
){

    val loginState by remember {
        loginViewModel.loginState
    }

    if (loginState.isLoginSuccessful){
        LaunchedEffect(key1 = true) {
            navigateToAuthenticatedRoute.invoke()
        }
    } else {

        Box(modifier = Modifier.fillMaxSize()) {
            TopStartColumn {
                IconBackButton(onClick = { navigateBack.invoke() },
                    color = md_theme_light_onPrimary)
            }

            ScrollableColumn {
                ImageMaxWidth(img = R.drawable.login_sheep)
//                GifImage(modifier = Modifier.fillMaxWidth(), R.drawable.welcome_sheep)

                GapColumn(
                    modifier = Modifier
                            .padding(vertical = dimensionResource(id = R.dimen.padding_none),
                                horizontal = dimensionResource(id = R.dimen.padding_medium),
                            )
                ) {
                    GradientTitleText(
                        text = stringResource(id = R.string.title_activity_login_welcome),
                        gradient = GRA_VER_BLACK_PURPLE,
                    )

                    SubTitleText(
                        text = stringResource(id = R.string.login_text),
                    )

                    MediumSpace()

                    GradientTextField(
                        stringResource(id = R.string.prompt_nickname),
                        stringResource(id = R.string.focused_nickname),
                        Icons.Rounded.Person,
                        KeyboardType.Text,
                    )


                    GradientPasswordField(
                        stringResource(id = R.string.prompt_password),
                        stringResource(id = R.string.focused_password),
                        Icons.Rounded.Lock,
                    )

                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        modifier = Modifier
                            .padding(
                                top = dimensionResource(id = R.dimen.padding_small),
                                bottom = dimensionResource(id = R.dimen.padding_smaller)
                            )
                            .fillMaxWidth()
                            .clickable {
                                navigateToForgotPassword.invoke()
                            },
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.End,
                        color = md_theme_light_onPrimaryContainer,
                    )

                    LargeSpace()

                    GradientButton(
                        text = stringResource(id = R.string.action_login),
                        gradient = GRA_HOR_BLACK_PURPLE,
                        onClick = {
                            loginViewModel.onLoginUiEvent(loginUiEvent = LoginUiEvent.Submit)
                            navigateToAuthenticatedRoute.invoke()
                        }
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        ContextText(
                            text = stringResource(id = R.string.to_register_text),
                            textAlign = TextAlign.Center,
                        )
                        NavigationText(
                            text = stringResource(id = R.string.title_activity_register),
                            textAlign = TextAlign.Center,
                            onClick = {
                                navigateToRegistration.invoke()
                            }
                        )
                    }
                    MediumSpace()
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview(){
    EventifyTheme(darkTheme = false){
        LoginScreenView(
            navigateToRegistration = {},
            navigateToForgotPassword = {},
            navigateToAuthenticatedRoute = {},
            navigateBack = {}
        )
    }
}
