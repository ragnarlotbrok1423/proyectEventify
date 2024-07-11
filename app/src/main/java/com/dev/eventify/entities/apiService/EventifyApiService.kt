package com.dev.eventify.entities.apiService

import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.Post
import com.dev.eventify.entities.models.PostResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventifyApiService {
    @POST("api/posts")
    suspend fun  createPost(@Body post: Post ): Post
    @POST("api/facultadesXpostXprofesores")
    suspend fun createPublication(@Body publication: FacultadesXpostsXprofesores ): FacultadesXpostsXprofesores
    @GET("api/facultadesXpostXprofesores")
    suspend fun getPublication(): FacultadesXpostsXprofesores
    @GET("api/facultadesXpostXprofesores/{id}")
    suspend fun getEspecificPublication(@Path("id") id: Int): FacultadesXpostsXprofesores
    @GET("api/estudiantes")
    suspend fun getEstudentLogin(): Response<List<Estudiantes>>

}
object EventifyService{
    private const val baseUrl = "https://eventify.com/"
    val instance: EventifyApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(EventifyApiService::class.java)
    }
}
