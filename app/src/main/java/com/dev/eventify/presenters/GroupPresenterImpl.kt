package com.dev.eventify.presenters

import com.dev.eventify.entities.GroupInteractors
import com.dev.eventify.entities.models.Group
import com.dev.eventify.entities.models.Post
import com.dev.eventify.views.GroupView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupPresenterImpl(
    private val view: GroupView,
    private val interactor: GroupInteractors
) {
    fun createPost(comentario: String, titulo: String, imagen: String) {
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val post = interactor.createPost(comentario, titulo, imagen)
            view.hideLoading()
            if (post != null) {
                view.showPostCreated(post)
            } else {
                view.showError("Failed to create post")
            }
        }
    }

    fun createGroup(name: String, description: String, image: String) {
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val group = interactor.createGroup(name, description, image)
            view.hideLoading()
            if (group != null) {
                view.showGroupCreated(group)
            } else {
                view.showError("Failed to create group")
            }
        }
    }

    fun createPostInGroup(groupId: Int, comentario: String, titulo: String, imagen: String) {
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val post = interactor.createPostInGroup(groupId, comentario, titulo, imagen)
            view.hideLoading()
            if (post != null) {
                view.showPostCreated(post)
            } else {
                view.showError("Failed to create post in group")
            }
        }
    }
}
