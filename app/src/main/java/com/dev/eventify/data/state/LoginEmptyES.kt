package com.dev.eventify.data.state

import com.dev.eventify.R

val emailOrUsernameEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_invalid_email_username
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_invalid_password
)