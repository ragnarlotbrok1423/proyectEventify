package com.dev.eventify.entities

import com.dev.eventify.entities.models.Materias
import com.dev.eventify.entities.models.Result
import com.dev.eventify.entities.models.Valoraciones
import com.dev.eventify.entities.models.ValoracionesResponse

interface ProfesoresInterface {
   suspend fun createProfesor(nombre: String, apellido: String, email: String, password: String, userType:Int, imagen:String?, descripcion:String?): com.dev.eventify.entities.models.Result<Boolean>
   suspend fun getMaterias(): Result<List<Materias>>
}

interface ProfesoresViewInterface{
   fun mostrarValoraciones(valoraciones :List<ValoracionesResponse>, promedio:Double)
   fun showError(message: String)
}

