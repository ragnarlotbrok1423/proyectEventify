package com.dev.eventify.data.state.login

sealed class LoginUiEvent {
    data class EmailOrNicknameChange(val inputValue: String) : LoginUiEvent()
    data class PasswordChange(val inputValue: String) : LoginUiEvent()
    object Submit : LoginUiEvent()
}