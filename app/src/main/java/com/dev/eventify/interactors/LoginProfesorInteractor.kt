package com.dev.eventify.interactors

import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.entities.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginProfesorInteractor (private val apiService: EventifyApiService){
    suspend fun loginProfesor(email: String, password: String): Result<Profesores>{
        return withContext(Dispatchers.IO){
            try {
                val response= apiService.getProfesorsLogin()
                if (response.isSuccessful){
                    val profesores= response.body() ?: emptyList()
                    val profesor= profesores.find { it.email == email && it.password==password }
                    if(profesor!=null){
                        Result(data = profesor, error = null)
                    }else{
                        Result(data = null, error="Credenciales Incorrectas")
                    }
                }else{
                    Result(data = null, error = "Error al obtener los datos de estudiantes")
                }
            }catch (e: Exception){
                Result(data = null, error = e.message)
            }
        }
    }
}