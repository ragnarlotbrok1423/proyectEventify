package com.dev.eventify.entities

import com.dev.eventify.entities.models.Profesores

interface SetControlProf {
    fun loadProfileData(professorId: String)
    fun updateProfile(professor: Profesores)
    fun changeProfilePicture(imagen: String?)
}
