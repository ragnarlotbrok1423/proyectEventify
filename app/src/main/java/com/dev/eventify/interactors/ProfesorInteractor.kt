package com.dev.eventify.interactors

import com.dev.eventify.entities.apiService.EventifyApiService

import com.dev.eventify.entities.PostProfesores
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.entities.models.ProfesoresResponse

class ProfesorInteractor(private val apiService:EventifyApiService):PostProfesores {
    var sucsessMessage:String="Profesor registrado correctamente"
    override suspend fun createProfesor(
        nombre: String,
        apellido: String,
        email: String,
        password: String,
        rol: Int,
        imagen: String?,
        descripcion: String?
    ): String {
      return try {
            apiService.postProfesores(ProfesoresResponse
               (
                       nombre,
                       apellido,
                       email,
                       password,
                       2,
                       null,
                       null
                       ))
          sucsessMessage

      }catch (e:Exception){
          throw Exception("Error creando Profesor: ${e.message}")

      }
    }
}