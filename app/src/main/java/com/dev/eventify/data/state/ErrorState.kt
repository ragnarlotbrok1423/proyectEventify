package com.dev.eventify.data.state

import androidx.annotation.StringRes
import com.dev.eventify.R

data class ErrorState (
    val hasError : Boolean = false,
    // StringResource
    @StringRes val errorMessage : Int = R.string.empty_prompt
)