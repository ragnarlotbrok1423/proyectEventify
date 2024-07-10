package com.dev.eventify.interactors

import com.dev.eventify.entities.EstudiantesInterface
import com.dev.eventify.entities.ProfesoresInterface
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.GruposXpostXestudiantes
import com.dev.eventify.entities.models.Profesores

class ProfesoresInteractor(private val apiService: EventifyApiService): ProfesoresInterface{
    override suspend fun createProfesores(
        nombres: String,
        apellido: String,
        email: String,
        password: String,
        imagen: String?,
        descripcion: String?
    ): Profesores? {
        return try {
            apiService.createProfesores(Profesores(nombres, apellido, email, password, imagen, descripcion))
        }
        catch (e: Exception){
            error(e)
        }
    }


}
