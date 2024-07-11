package com.dev.eventify.presenters

import com.dev.eventify.entities.apiService.EventifyService
import com.dev.eventify.entities.models.Estudiantes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun postEstudiante(estudiante: Estudiantes, onResult: (Estudiantes?) -> Unit) {
    try {
        val result = withContext(Dispatchers.IO) {
            EventifyService.instance.createEstudiantes(estudiante)
        }
        onResult(result)
    } catch (e: Exception) {
        e.printStackTrace()
        onResult(null)
    }
}