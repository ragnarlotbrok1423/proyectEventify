package com.dev.eventify.views

import com.dev.eventify.entities.models.ProfesoresResponse

class ProfileViewTest : ProfileView {
    override fun showLoading() {
        println("Loading...")
    }

    override fun hideLoading() {
        println("Loading finished.")
    }

    override fun displayProfileData(professor: ProfesoresResponse) {
        println("Professor Data: $professor")
    }

    override fun showError(message: String) {
        println("Error: $message")
    }

    override fun showSuccess(message: String) {
        println("Success: $message")
    }

    override fun updateProfilePicture(url: String) {
        println("Profile Picture Updated: $url")
    }
}
