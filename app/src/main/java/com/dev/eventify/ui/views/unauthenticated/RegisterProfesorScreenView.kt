package com.dev.eventify.ui.views.unauthenticated

import android.content.ContentValues.TAG
import android.util.Log
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
import androidx.compose.material.icons.rounded.PermIdentity
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dev.eventify.R
import com.dev.eventify.data.validateConfirmPassword
import com.dev.eventify.data.validateEmail
import com.dev.eventify.data.validateInput
import com.dev.eventify.data.validatePassword
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.presenters.postProfesor
import com.dev.eventify.ui.components.ContextText
import com.dev.eventify.ui.components.GapColumn
import com.dev.eventify.ui.components.GradientButton
import com.dev.eventify.ui.components.GradientPasswordField
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
import kotlinx.coroutines.launch

@Composable
fun RegisterProfessorScreenView(
    navigateToLogin: () -> Unit,
    navigateToAuthenticatedRoute: () -> Unit,
    navigateBack: () -> Unit,
    onSubmit: (Profesores) -> Unit
){

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var nameErrorMessage by remember { mutableStateOf<String?>(null) }
    var surnameErrorMessage by remember { mutableStateOf<String?>(null) }
    var emailErrorMessage by remember { mutableStateOf<String?>(null) }
    var passwordErrorMessage by remember { mutableStateOf<String?>(null) }
    var confirmPasswordErrorMessage by remember { mutableStateOf<String?>(null) }

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ){

        ScrollableColumn {
            TopStartColumn {
                IconBackButton(onClick = { navigateBack.invoke() },
                    color = DARK_BLUE
                )
            }

            GapColumn(
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_none),
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                    )
            ) {

                HugeSpace()

                GradientTitleText(
                    text = stringResource(id = R.string.title_activity_register_professor),
                    gradient = GRA_VER_BLACK_PURPLE,
                )

                SubTitleText(
                    text = stringResource(id = R.string.register_text),
                )

                MediumSpace()

                GradientTextField(
                    stringResource(id = R.string.prompt_name),
                    stringResource(id = R.string.focused_name),
                    Icons.Rounded.Person,
                    KeyboardType.Text,
                    value = name,
                    onValueChange = {
                        name = it
                        nameErrorMessage = validateInput(it)
                    },
                    isError = nameErrorMessage != null,
                    errorText = nameErrorMessage ?: ""
                )

                GradientTextField(
                    stringResource(id = R.string.prompt_surname),
                    stringResource(id = R.string.focused_surname),
                    Icons.Rounded.PermIdentity,
                    KeyboardType.Text,
                    value = surname,
                    onValueChange = {
                        surname = it
                        surnameErrorMessage = validateInput(it)
                    },
                    isError = surnameErrorMessage != null,
                    errorText = surnameErrorMessage ?: ""
                )

                GradientTextField(
                    stringResource(id = R.string.prompt_email),
                    stringResource(id = R.string.focused_email),
                    Icons.Rounded.Email,
                    KeyboardType.Email,
                    value = email,
                    onValueChange = {
                        email = it
                        emailErrorMessage = validateEmail(it)
                    },
                    isError = emailErrorMessage != null,
                    errorText = emailErrorMessage ?: ""
                )

                GradientPasswordField(
                    stringResource(id = R.string.prompt_password),
                    stringResource(id = R.string.focused_password),
                    Icons.Rounded.Lock,
                    value = password,
                    onValueChange = {
                        password = it
                        passwordErrorMessage = validatePassword(it)
                    },
                    isError = passwordErrorMessage != null,
                    errorText = passwordErrorMessage ?: ""
                )

                GradientPasswordField(
                    stringResource(id = R.string.prompt_password_confirm),
                    stringResource(id = R.string.focused_password_confirm),
                    Icons.Outlined.Lock,
                    value = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                        confirmPasswordErrorMessage = validateConfirmPassword(it, password)
                    },
                    isError = confirmPasswordErrorMessage != null,
                    errorText = confirmPasswordErrorMessage ?: ""
                )

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
                        if(
                            nameErrorMessage == null
                            && surnameErrorMessage == null
                            && emailErrorMessage == null
                            && passwordErrorMessage == null
                            && confirmPasswordErrorMessage == null
                            ) {
                            val professor =
                                Profesores(
                                    nombre = name,
                                    apellido = surname,
                                    email = email,
                                    password = password,
                                    imagen = null,
                                    descripcion = null,
                                )

                            scope.launch {
                                postProfesor(professor) { result ->
                                    if (result != null) {
                                        onSubmit(result)
                                        navigateToAuthenticatedRoute.invoke()
                                    } else {
                                        Log.e("Register", "Error registering professor")
                                    }
                                }
                            }
                        }
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
fun RegisterProfessorPreview(){
    EventifyTheme (darkTheme= false) {
        RegisterProfessorScreenView(
            navigateBack = {},
            navigateToLogin = {},
            navigateToAuthenticatedRoute = {}
        ){professor ->
            Log.i(TAG, professor.toString())
        }
    }
}