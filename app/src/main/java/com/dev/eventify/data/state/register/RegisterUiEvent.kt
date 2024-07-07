package com.dev.eventify.data.state.register

sealed class RegisterUiEvent {
    data class NicknameChange(val inputValue: String) : RegisterUiEvent()
    data class EmailChage(val inputValue: String) : RegisterUiEvent()
    data class PasswordChange(val inputValue: String) : RegisterUiEvent()
    data class PhoneNumberChange(val inputValue: String) : RegisterUiEvent()
    data class FacultyChange(val inputValue: String) : RegisterUiEvent()
    data class CareerChange(val inputValue: String) : RegisterUiEvent()
    data class LevelChange(val inputValue: String) : RegisterUiEvent()
    object Submit: RegisterUiEvent()
}