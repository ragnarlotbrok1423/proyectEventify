package com.dev.eventify.entities

interface LoginViewInterface {
    fun onLoginSuccess(userId: Int, userType: Int)
    fun loginError(error: String)
    abstract fun onLoginError(error: String)
}