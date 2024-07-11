package com.dev.eventify.entities

import com.dev.eventify.entities.models.Materias
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.entities.models.ProfesoresResponse
import com.dev.eventify.entities.models.Result

interface ProfesoresInterface {
   suspend fun createProfesor(
      nombre: String,
      apellido: String,
      email: String,
      password: String,
      userType: Int,
      imagen: String?,
      descripcion: String?
   ): Result<Boolean>

   suspend fun getMaterias(): Result<List<Materias>>

   suspend fun getProfesor(profesorId: String): Result<ProfesoresResponse>

   suspend fun updateProfesor(profesor: Profesores): Result<Boolean>

   suspend fun updateProfilePicture(imagen: String?): Result<String>
}
