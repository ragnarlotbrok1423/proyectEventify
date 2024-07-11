package com.dev.eventify.entities.apiService

import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.Facultades
import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.GruposXpostXestudiantes
import com.dev.eventify.entities.models.Materia
import com.dev.eventify.entities.models.Post
import com.dev.eventify.entities.models.Profesores
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventifyApiService {

//    ya hice
    @POST("api/estudiantes")
    suspend fun createEstudiantes(@Body estudiantes: Estudiantes): Estudiantes
    @POST("api/Profesores")
    suspend fun createProfesores(@Body profesores: Profesores): Profesores

//    no pude
    @POST("api/GruposXpostXestudiantes")
    suspend fun createGroupPublication(@Body groupPublication: GruposXpostXestudiantes): GruposXpostXestudiantes
    @POST("api/posts")
    suspend fun  createPost(@Body post: Post ): Post
    @POST("api/facultadesXpostXprofesores")
    suspend fun createPublication(@Body publication: FacultadesXpostsXprofesores ): FacultadesXpostsXprofesores

    @GET("api/estudiantes")
    suspend fun getStudent(): Estudiantes
    @GET("api/Profesores")
    suspend fun getProfessor(): Profesores
    @GET("api/Facultades")
    suspend fun getFacultad(): Facultades
    @GET("api/Facultades")
    suspend fun getAllFacultades(): Call<List<Facultades>>
    @GET("api/Materia")
    suspend fun getMaterial(): Materia
    @GET("api/GruposXpostXestudiantes")
    suspend fun getGroupPublication(): GruposXpostXestudiantes

//    remote
    @GET("api/facultadesXpostXprofesores")
    suspend fun getPublication(): FacultadesXpostsXprofesores
    @GET("api/facultadesXpostXprofesores/{id}")
    suspend fun getEspecificPublication(@Path("id") id: Int): FacultadesXpostsXprofesores
}
object EventifyService{
    private const val baseUrl = "http://127.0.0.1:4040"
    val instance: EventifyApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(EventifyApiService::class.java)
    }
}