package com.dev.eventify.presenters

import com.dev.eventify.entities.SetControlProf
import com.dev.eventify.interactors.ProfesorInteractor
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.views.ProfileView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfilePresenterImpl(
    private val view: ProfileView,
    private val interactor: ProfesorInteractor
) : SetControlProf {

    override fun loadProfileData(professorId: String) {
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val result = interactor.getProfesor(professorId)
            if (result.data != null) {
                view.hideLoading()
                view.displayProfileData(result.data)
            } else {
                view.hideLoading()
                view.showError(result.error ?: "Unknown error")
            }
        }
    }

    override fun updateProfile(professor: Profesores) {
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val result = interactor.updateProfesor(professor)
            if (result.data == true) {
                view.hideLoading()
                view.showSuccess("Profile updated successfully")
            } else {
                view.hideLoading()
                view.showError(result.error ?: "Unknown error")
            }
        }
    }

    override fun changeProfilePicture(imagen: String?) {
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val result = interactor.updateProfilePicture(imagen)
            if (result.data != null) {
                view.hideLoading()
                view.updateProfilePicture(result.data)
            } else {
                view.hideLoading()
                view.showError(result.error ?: "Unknown error")
            }
        }
    }
}
