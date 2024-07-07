package com.dev.eventify.data.state.login

import com.dev.eventify.R
import com.dev.eventify.data.state.ErrorState

val emailOrNicknameEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_invalid_email_nickname
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_invalid_password
)