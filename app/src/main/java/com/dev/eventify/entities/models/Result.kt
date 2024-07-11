package com.dev.eventify.entities.models

data class Result<T>(
    val data:T?,
    val error:String?
)
