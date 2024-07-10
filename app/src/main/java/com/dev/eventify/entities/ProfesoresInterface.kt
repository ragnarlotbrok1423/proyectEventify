package com.dev.eventify.entities

import com.dev.eventify.entities.models.Profesores

interface ProfesoresInterface {
    suspend fun createProfesores(nombres:String, apellido: String, email: String,password: String, imagen: String?, descripcion: String?): Profesores?

}