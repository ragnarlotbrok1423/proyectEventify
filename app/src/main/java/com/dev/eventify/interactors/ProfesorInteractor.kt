package com.dev.eventify.interactors

import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.ProfesoresInterface
import com.dev.eventify.entities.models.Materias
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.entities.models.ProfesoresResponse
import com.dev.eventify.entities.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfesorInteractor(private val apiService: EventifyApiService): ProfesoresInterface {

    override suspend fun createProfesor(
        nombre: String,
        apellido: String,
        email: String,
        password: String,
        userType: Int,
        imagen: String?,
        descripcion: String?
    ): Result<Boolean> {
        return withContext(Dispatchers.IO){
            try {
                var response= apiService.createProfesors(nombre,apellido,email,password,userType,imagen,descripcion)
                if(response.isSuccessful){
                    Result(data = true, error = null)
                }else{
                    Result(data = false, error = null)
                }
            }catch (e:Exception){
                Result(data = false, error = e.message)
            }
        }

    }


    override suspend fun getMaterias(): Result<List<Materias>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getMaterias()
                if (response.isSuccessful) {
                    Result(data = response.body(), error = null)
                } else {
                    Result(data = null, error = "Failed to load materias")
                }
            } catch (e: Exception) {
                Result(data = null, error = e.message)
            }
        }
    }

    override suspend fun getProfesor(profesorId: String): Result<ProfesoresResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getProfesor(profesorId)
                if (response.isSuccessful) {
                    Result(data = response.body(), error = null)
                } else {
                    Result(data = null, error = "Failed to load profile")
                }
            } catch (e: Exception) {
                Result(data = null, error = e.message)
            }
        }
    }

    override suspend fun updateProfesor(profesor: Profesores): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.updateProfesor(profesor)
                if (response.isSuccessful) {
                    Result(data = true, error = null)
                } else {
                    Result(data = false, error = "Failed to update profile")
                }
            } catch (e: Exception) {
                Result(data = false, error = e.message)
            }
        }
    }

    override suspend fun updateProfilePicture(imagen: String?): Result<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.uploadProfilePicture(imagen)
                if (response.isSuccessful) {
                    Result(data = response.body(), error = null)
                } else {
                    Result(data = null, error = "Failed to upload profile picture")
                }
            } catch (e: Exception) {
                Result(data = null, error = e.message)
            }
        }
    }
}
