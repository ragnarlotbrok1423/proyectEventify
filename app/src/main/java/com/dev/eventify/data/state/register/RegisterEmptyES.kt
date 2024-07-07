package com.dev.eventify.data.state.register

import com.dev.eventify.R
import com.dev.eventify.data.state.ErrorState

val nicknameEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_nickname
)

val emailEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_email
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_password
)

val phoneNumberEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_mobile
)

val facultyEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_faculty
)

val careerEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_career
)

val levelEmptyErrorState = ErrorState(
    hasError = true,
    errorMessage = R.string.error_register_level
)