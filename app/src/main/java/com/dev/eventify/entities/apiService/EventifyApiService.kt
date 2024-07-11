package com.dev.eventify.entities.apiService

import com.dev.eventify.entities.models.Estudiantes
import com.dev.eventify.entities.models.EstudiantesResponse
import com.dev.eventify.entities.models.Facultades
import com.dev.eventify.entities.models.FacultadesXpostsXprofesores
import com.dev.eventify.entities.models.Materias
import com.dev.eventify.entities.models.Post
import com.dev.eventify.entities.models.PostResponse
import com.dev.eventify.entities.models.Profesores
import com.dev.eventify.entities.models.ProfesoresResponse
import com.dev.eventify.entities.models.ValoracionesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface EventifyApiService {
    @POST("api/posts")
    suspend fun  createPost(@Body post: Post ): Post
    @POST("api/facultadesXpostXprofesores")
    suspend fun createPublication(@Body publication: FacultadesXpostsXprofesores ): FacultadesXpostsXprofesores
    @GET("api/facultadesXpostXprofesores")
    suspend fun getPublication(): FacultadesXpostsXprofesores

    @GET("api/facultadesXpostXprofesores/{id}")
    suspend fun getEspecificPublication (@Path("id") id: Int): FacultadesXpostsXprofesores
    @POST("api/estudiantes")
    suspend fun createStudent(
        @Query("nickName")nickName:String,
        @Query("password") password:String,
        @Query("imagen") imagen:String?,
        @Query("descripcion") descripcion:String?,
        @Query("rol") rol:Int,
        @Query("facultadesId") facultadesId:Int
    ): Response<Void>
    @GET("api/estudiantes")
    suspend fun getEstudiantes():Estudiantes
    @POST ("api/profesores")

    suspend fun createProfesors(
        @Query("nombre") nombre:String,
        @Query("apellido") apellido:String,
        @Query("email") email:String,
        @Query("password") password: String,
        @Query("userType") userType:Int,
        @Query("imagen") imagen:String?,
        @Query("descripcion") descripcion:String?

    ):Response<Void>
    @GET("api/Facultades")
    suspend fun  getFacultades():Response<List<Facultades>>
    @GET("api/estudiantes")
    suspend fun getEstudentLogin():Response<List<EstudiantesResponse>>
    @GET("api/profesores")
    suspend fun getProfesorsLogin():Response<List<ProfesoresResponse>>

    @POST ("api/Valoraciones")
    suspend fun createValoracion(
        @Query("valoracion") valoracion: Int,
        @Query("comentario") comentario:String?,
    ): Response<ValoracionesResponse>

    @POST ("api/ValoracionesXestudiantesXprofesores")
    suspend fun createIncognitePost(
        @Query("estudianteId") estudianteId:Int,
        @Query("profesorId") profesorId:Int,
        @Query("valoracionId") valoracionId:Int,
    ): Response<Void>

    @GET("api/Materias")
    suspend fun getMaterias():Response<List<Materias>>
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
