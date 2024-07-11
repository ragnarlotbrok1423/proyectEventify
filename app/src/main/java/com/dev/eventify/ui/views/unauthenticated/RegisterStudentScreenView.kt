package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.eventify.R
import com.dev.eventify.data.state.register.RegisterUiEvent
import com.dev.eventify.ui.components.ContextText
import com.dev.eventify.ui.components.ExtraHugeSpace
import com.dev.eventify.ui.components.FacultySelectTextField
import com.dev.eventify.ui.components.GapColumn
import com.dev.eventify.ui.components.GradientButton
import com.dev.eventify.ui.components.GradientPasswordField
import com.dev.eventify.ui.components.GradientPhoneTextField
import com.dev.eventify.ui.components.GradientTextField
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.components.HugeSpace
import com.dev.eventify.ui.components.IconBackButton
import com.dev.eventify.ui.components.ImageMaxWidth
import com.dev.eventify.ui.components.MaxWidthText
import com.dev.eventify.ui.components.MediumSpace
import com.dev.eventify.ui.components.NavigationText
import com.dev.eventify.ui.components.ScrollableColumn
import com.dev.eventify.ui.components.SubTitleText
import com.dev.eventify.ui.components.TopStartColumn
import com.dev.eventify.ui.themes.DARK_BLUE
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.GRA_VER_BLACK_PURPLE
import com.dev.eventify.ui.viewModels.unauthenticated.RegisterViewModel

@Composable
fun RegisterStudentScreenView(
    navigateToLogin: () -> Unit,
    navigateToAuthenticatedRoute: () -> Unit,
    navigateBack: () -> Unit,
){
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        TopStartColumn {
            IconBackButton(onClick = { navigateBack.invoke() },
                color = DARK_BLUE)
        }

        ScrollableColumn {

            GapColumn(
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_none),
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                    )
            ) {

                ExtraHugeSpace()

                GradientTitleText(
                    text = stringResource(id = R.string.action_register),
                    gradient = GRA_VER_BLACK_PURPLE,
                )

                SubTitleText(
                    text = stringResource(id = R.string.register_text),
                )

                MediumSpace()

                GradientTextField(
                    stringResource(id = R.string.prompt_nickname),
                    stringResource(id = R.string.focused_nickname),
                    Icons.Rounded.Person,
                    KeyboardType.Text,
                )

                GradientTextField(
                    stringResource(id = R.string.prompt_email),
                    stringResource(id = R.string.focused_email),
                    Icons.Rounded.Email,
                    KeyboardType.Email,
                )

                GradientPasswordField(
                    stringResource(id = R.string.prompt_password),
                    stringResource(id = R.string.focused_password),
                    Icons.Rounded.Lock,
                )

                GradientPasswordField(
                    stringResource(id = R.string.prompt_password_confirm),
                    stringResource(id = R.string.focused_password_confirm),
                    Icons.Outlined.Lock,
                )

                GradientPhoneTextField()

                FacultySelectTextField(
                    label = stringResource(id = R.string.prompt_faculty),
                    )
//                    RegisterStudentInput(
//                        registrationState = registrationState,
//                        onNicknameChange = ,
//                        onEmailChange =,
//                        onPasswordChange = ,
//                        onConfirmPasswordChange = ,
//                        onMobileNumberChange = ,
//                    ) {
////
//                    }

                Column(
                    modifier = Modifier.width(dimensionResource(id = R.dimen.container_width)),
                ) {
                    MaxWidthText(
                        text = stringResource(id = R.string.term_condition),
                        textAlign = TextAlign.Justify,
                    )
                }

                HugeSpace()

                GradientButton(
                    text = stringResource(id = R.string.action_register),
                    gradient = GRA_HOR_BLACK_PURPLE,
                    onClick = {
//                        val listStudents = registerViewModel.onRegisterUiEvent(registerUiEvent = RegisterUiEvent.Submit)
//                        println( listStudents.toString())
//                            if(registerState.value)
                        navigateToAuthenticatedRoute.invoke()
                    }
                )

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ContextText(
                        text = stringResource(id = R.string.to_register_text),
                        textAlign = TextAlign.Center,
                    )
                    NavigationText(
                        text = stringResource(id = R.string.title_activity_login),
                        textAlign = TextAlign.Center,
                        onClick = {
                            navigateToLogin.invoke()
                        }
                    )
                }
                MediumSpace()
            }

            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
            ){
                ImageMaxWidth(
                    img = R.drawable.register_sheep)
            }
        }
    }
}

@Preview
@Composable
fun RegisterStudentPreview(){
    EventifyTheme (darkTheme= false) {
        RegisterProfessorScreenView(
            navigateBack = {},
            navigateToLogin = {},
            navigateToAuthenticatedRoute = {}
        )
    }
}