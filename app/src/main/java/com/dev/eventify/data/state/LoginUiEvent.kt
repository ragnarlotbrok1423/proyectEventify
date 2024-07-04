package com.dev.eventify.data.state

sealed class LoginUiEvent {
    data class EmailOrUsernameChange(val inputEmailOrUsername: String) : LoginUiEvent()
    data class PasswordChange(val inputPassword: String) : LoginUiEvent()
    object Submit : LoginUiEvent()
}