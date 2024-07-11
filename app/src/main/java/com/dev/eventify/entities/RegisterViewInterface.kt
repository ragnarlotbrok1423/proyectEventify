package com.dev.eventify.entities

interface RegisterViewInterface {
    fun onRegister()
    fun navigateTo()
    fun showError(message: String)

}