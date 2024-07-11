package com.dev.eventify.views

import com.dev.eventify.entities.models.ProfesoresResponse

interface ProfileView {
    fun showLoading()
    fun hideLoading()
    fun displayProfileData(professor: ProfesoresResponse)
    fun showError(message: String)
    fun showSuccess(message: String)
    fun updateProfilePicture(url: String)
}
