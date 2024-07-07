package com.dev.eventify.data.state.login

import com.dev.eventify.data.state.ErrorState

data class LoginState(
    val emailOrNickname : String = "",
    val password : String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful : Boolean = false
)

data class LoginErrorState(
    val emailOrNicknameErrorState : ErrorState = ErrorState(),
    val passwordErrorState : ErrorState = ErrorState(),
)