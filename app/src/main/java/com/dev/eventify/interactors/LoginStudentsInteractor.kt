package com.dev.eventify.interactors


import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Estudiantes
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class LoginEstudentInteractor(private val apiService: EventifyApiService) {
    suspend fun  loginEstudent(nickName: String, password: String): Result<Estudiantes?> {
        return withContext(Dispatchers.IO){
            try {
                val response= apiService.getEstudentLogin()
                if (response.isSuccessful){
                    val estudiantes= response.body() ?: emptyList()
                    val estudiante= estudiantes.find{it.nickName == nickName && it.password == password}
                    if (estudiante !==null){
                        com.dev.eventify.entities.models.Result(data = estudiante, error = null)
                    }else{
                        Result(data = null, error="Credenciales Incorrectas")
                    }
                }else{
                    Result(data = null, error = "Error al obtener los datos de estudiantes")
                }
            }catch (e: Exception){
                Result(data = null, error = e.message)
            } as Result<Estudiantes?>
        }
    }
}

data class Result<T>(
    val data: T?,
    val error: String?
) {
    companion object
}