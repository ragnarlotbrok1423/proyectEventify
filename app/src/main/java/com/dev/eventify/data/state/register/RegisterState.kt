package com.dev.eventify.data.state.register

import com.dev.eventify.data.state.ErrorState


data class RegisterState (
    val nickname: String = "",
    val email: String = "",
    val password: String = "",
    val oldPassword: String = "",
    val phoneNumber: String = "",
    val faculty: String = "",
    val errorState: RegisterErrorState = RegisterErrorState(),
    val isRegisterSuccessful : Boolean = false
    )

data class RegisterErrorState(
    val nicknameErrorState: ErrorState = ErrorState(),
    val emailErrorState: ErrorState = ErrorState(),
    val passwordErrorState: ErrorState = ErrorState(),
    val oldPasswordErrorState: ErrorState = ErrorState(),
    val phoneNumberErrorState: ErrorState = ErrorState(),
    val facultyErrorState: ErrorState = ErrorState(),
    )