package ru.netology.service

import ru.netology.Post
import ru.netology.Users
import ru.netology.attachments.Attachments
import ru.netology.attachments.AttachmentsAudio
import ru.netology.attachments.Audio

var counter = 1

object WallService {
    private var posts = emptyArray<Post>()
    private var users = emptyArray<Users>()

    fun addPost(post: Post): Post {
        val assistantPost = post.copy(id = counter)
        counter += 1
        posts += assistantPost
        return posts.last()
    }

    fun addUsers(user: Users): Users {
        users += user
        return users.last()
    }

    fun updatePost(post: Post, newText: String): Boolean {
        posts.forEachIndexed { index, postElement ->
            if (post.id == postElement.id) {
                posts[index] = postElement.copy(text = newText)
                return true
            }
        }
        return false
    }
}