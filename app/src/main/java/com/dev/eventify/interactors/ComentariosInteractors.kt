package com.dev.eventify.interactors

import com.dev.eventify.entities.ComentariosInteractors
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Comentario

class ComentariosInteractor(private val apiService: EventifyApiService) : ComentariosInteractors {

    override suspend fun createComentario(profesorId: Int, materiaId: Int, valoracion: Int, comentario: String): Comentario? {
        return try {
            apiService.createComentario(Comentario(profesorId = profesorId, materiaId = materiaId, valoracion = valoracion, comentario = comentario))
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getComentariosByProfesor(profesorId: Int): List<Comentario>? {
        return try {
            apiService.getComentariosByProfesor(profesorId)
        } catch (e: Exception) {
            null
        }
    }
}
