package com.dev.eventify.views

import com.dev.eventify.entities.models.Group
import com.dev.eventify.entities.models.Post

interface GroupView {
    fun showLoading()
    fun hideLoading()
    fun showPostCreated(post: Post)
    fun showGroupCreated(group: Group)
    fun showError(message: String)
}
