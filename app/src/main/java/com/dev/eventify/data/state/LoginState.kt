package com.dev.eventify.data.state

data class LoginState(
    val emailOrUsername : String = "",
    val password : String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful : Boolean = false
)

data class LoginErrorState(
    val emailOrUsernameErrorState : ErrorState = ErrorState(),
    val passwordErrorState : ErrorState = ErrorState(),
)