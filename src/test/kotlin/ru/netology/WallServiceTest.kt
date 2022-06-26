package ru.netology

import org.junit.Test

import org.junit.Assert.*
import ru.netology.service.WallService

class WallServiceTest {

    @Test
    fun addUsers() {
        val user: Users = Users("Степан")
        val userReturn = WallService.addUsers(user)
        val result = user.id
        assertTrue(result != 0)

    }

    @Test
    fun updatePostResultFalse() {
        val service = WallService
//        service.addPost(Post(1,1,1,1,"qq"))
//        service.addPost(Post(2,1,1,1,"qq"))
        service.addPost(Post(3, 1, 1, 1, "qq", arrayAttachments = null))
        val textNew = "ww"
        val result = WallService.updatePost(Post(5, 1, 1, 1, "qq", arrayAttachments = null), textNew)
        assertTrue(!result)
    }

    @Test
    fun updatePostResultTrue() {
        val service = WallService
        service.addPost(Post(1, 1, 1, 1, "qq", arrayAttachments = null))
        service.addPost(Post(2, 1, 1, 1, "qq", arrayAttachments = null))
        service.addPost(Post(3, 1, 1, 1, "qq", arrayAttachments = null))
        val textNew = "ww"
        val result = WallService.updatePost(Post(1, 1, 1, 1, "qq", arrayAttachments = null), textNew)
        assertTrue(result)
    }

    @Test
    fun createPostResultSuccess() {
        val service = WallService
        service.addPost(Post(1, 1, 1, 1, "qq", arrayAttachments = null))
//        service.addPost(Post(2, 1, 1, 1, "qq", arrayAttachments = null))
//        service.addPost(Post(3, 1, 1, 1, "qq", arrayAttachments = null))
        val result = service.createComment(1, Comment("wow", 39, 2, 5, null))
        assertTrue(result.id!=0)
    }

    @Test
    fun createPostResultException() {
        val service = WallService
        service.addPost(Post(1, 1, 1, 1, "qq", arrayAttachments = null))
        service.addPost(Post(2, 1, 1, 1, "qq", arrayAttachments = null))
        service.addPost(Post(3, 1, 1, 1, "qq", arrayAttachments = null))
        val result = WallService.createComment(5, Comment("wow", 39, 2, 5, null))
    }
}