package com.dev.eventify.presenters

import com.dev.eventify.entities.apiService.EventifyService
import com.dev.eventify.entities.models.Profesores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postProfesor(profesor: Profesores, onResult: (Profesores?) -> Unit) {
    try {
        val result = withContext(Dispatchers.IO) {
            EventifyService.instance.createProfesores(profesor)
        }
        onResult(result)
    } catch (e: Exception) {
        e.printStackTrace()
        onResult(null)
    }
}