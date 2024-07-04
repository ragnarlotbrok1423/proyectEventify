package com.dev.eventify.ui.viewModels.unauthenticated

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dev.eventify.data.state.ErrorState
import com.dev.eventify.data.state.LoginErrorState
import com.dev.eventify.data.state.LoginState
import com.dev.eventify.data.state.LoginUiEvent
import com.dev.eventify.data.state.emailOrUsernameEmptyErrorState
import com.dev.eventify.data.state.passwordEmptyErrorState

class LoginViewModel : ViewModel(){

    var loginState = mutableStateOf(LoginState()) // Initializer
        private set // setter es siempre privado y es de default implementation

    fun onLoginUiEvent(loginUiEvent: LoginUiEvent){
        when(loginUiEvent){
            is LoginUiEvent.EmailOrUsernameChange -> {
                loginState.value = loginState.value.copy(
                    emailOrUsername = loginUiEvent.inputEmailOrUsername,
                    errorState = loginState.value.errorState.copy(
                        emailOrUsernameErrorState = if (loginUiEvent.inputEmailOrUsername.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailOrUsernameEmptyErrorState
                    ))
            }

            is LoginUiEvent.PasswordChange -> {
                loginState.value = loginState.value.copy(
                    password = loginUiEvent.inputPassword,
                    errorState = loginState.value.errorState.copy(
                        passwordErrorState = if (loginUiEvent.inputPassword.trim().isNotEmpty())
                            ErrorState()
                        else
                            passwordEmptyErrorState
                    )
                )
            }

            is LoginUiEvent.Submit -> {
                val inputValidated = validateInputs()
                if (inputValidated)
                    loginState.value = loginState.value.copy(isLoginSuccessful = true)
            }
        }
    }

    private fun validateInputs(): Boolean{
        val emailOrUsername = loginState.value.emailOrUsername.trim()
        val password = loginState.value.password
        return when {

            emailOrUsername.isEmpty() ->{
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(emailOrUsernameErrorState = emailOrUsernameEmptyErrorState)
                )
                false
            }

            password.isEmpty() ->{
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(passwordErrorState = passwordEmptyErrorState)
                )
                false
            }

            // Cuando no hay errores, se envia como true y limpia los inputs
            else -> {
                loginState.value = loginState.value.copy(errorState = LoginErrorState())
                true
            }
        }
    }
}