package com.dev.eventify.ui.viewModels.unauthenticated

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dev.eventify.data.state.ErrorState
import com.dev.eventify.data.state.login.LoginErrorState
import com.dev.eventify.data.state.login.LoginState
import com.dev.eventify.data.state.login.LoginUiEvent
import com.dev.eventify.data.state.login.emailOrNicknameEmptyErrorState
import com.dev.eventify.data.state.login.passwordEmptyErrorState

class LoginViewModel : ViewModel(){

    var loginState = mutableStateOf(LoginState()) // Initializer
        private set // setter es siempre privado y es de default implementation

    fun onLoginUiEvent(loginUiEvent: LoginUiEvent){
        when(loginUiEvent){
            is LoginUiEvent.EmailOrNicknameChange -> {
                loginState.value = loginState.value.copy(
                    emailOrNickname = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        emailOrNicknameErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailOrNicknameEmptyErrorState
                    ))
            }

            is LoginUiEvent.PasswordChange -> {
                loginState.value = loginState.value.copy(
                    password = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        passwordErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
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
        val emailOrNickname = loginState.value.emailOrNickname.trim()
        val password = loginState.value.password
        return when {

            emailOrNickname.isEmpty() ->{
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(emailOrNicknameErrorState = emailOrNicknameEmptyErrorState)
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