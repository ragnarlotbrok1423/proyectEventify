package com.dev.eventify.data

import android.util.Patterns

fun validateInput(input: String): String? {
    return when {
        input.isEmpty() -> "This field cannot be empty"
        else -> null
    }
}


fun validatePassword(input: String): String? {
    val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$"
    return when {
        input.isEmpty() -> "Password cannot be empty"
        !input.matches(
            passwordRegex.toRegex(),
        ) -> "At least 8 characters with at least one uppercase letter, one lowercase letter, and one digit"
        else -> null
    }
}

fun validateEmail(email: String): String? {
    return when {
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Incorrect Email"
        else -> null
    }
}

fun validateConfirmPassword(input: String, compareInput: String): String?{
    return when{
        input.isEmpty() -> "This field cannot be empty"
        input !== compareInput -> "The password does not match"
        else -> null
    }
}