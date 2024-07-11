package com.dev.eventify.interactors

import com.dev.eventify.entities.GroupInteractors
import com.dev.eventify.entities.apiService.EventifyApiService
import com.dev.eventify.entities.models.Group
import com.dev.eventify.entities.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GroupInteractor(private val apiService: EventifyApiService) : GroupInteractors {

    override suspend fun createPost(comentario: String, titulo: String, imagen: String): Post? {
        return withContext(Dispatchers.IO) {
            val response = apiService.createPost(Post(comentario, titulo, imagen))
            handleResponse(response)
        }
    }

    override suspend fun createGroup(name: String, description: String, image: String): Group? {
        return withContext(Dispatchers.IO) {
            val response = apiService.createGroup(Group(0, name, description, image))
            handleResponse(response)
        }
    }

    override suspend fun createPostInGroup(groupId: Int, comentario: String, titulo: String, imagen: String): Post? {
        return withContext(Dispatchers.IO) {
            val response = apiService.createPost(Post(comentario, titulo, imagen, groupId))
            handleResponse(response)
        }
    }

    private fun <T> handleResponse(response: Response<T>): T? {
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}