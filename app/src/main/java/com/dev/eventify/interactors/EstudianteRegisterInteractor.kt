package com.dev.eventify.interactors

import com.dev.eventify.entities.EstudiantesInterface
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Facultades
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import com.dev.eventify.entities.models.Result


class EstudianteRegisterInteractor(private val apiService:EventifyApiService):EstudiantesInterface {
    override suspend fun createStudent(
        nickname: String,
        password: String,
        imagen: String?,
        descripcion: String?,
        rol: Int,
        facultadesId: Int
    ): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<Void> = apiService.createStudent(nickname, password, imagen, descripcion, rol, facultadesId)
                if (response.isSuccessful) {
                    Result(data = true, error = null)
                } else {
                    Result(data = false, error = null)
                }
            } catch (e: Exception) {
                Result(data = false, error = e.message)
            }
        }
    }

    override suspend fun getFacultades(): Result<List<Facultades>> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<List<Facultades>> = apiService.getFacultades()
                if (response.isSuccessful) {
                    Result(data = response.body(), error = null)
                } else {
                    Result(data = null, error = "Failed to load faculties")
                }
            } catch (e: Exception) {
                Result(data = null, error = e.message)
            }
        }
    }
}