package com.dev.eventify.entities

import com.dev.eventify.entities.models.Group
import com.dev.eventify.entities.models.Post

interface GroupInteractors {
    suspend fun createPost(comentario: String, titulo: String, imagen: String): Post?
    suspend fun createGroup(name: String, description: String, image: String): Group?
    suspend fun createPostInGroup(groupId: Int, comentario: String, titulo: String, imagen: String): Post?
}