package ru.netology

import org.junit.Test

import org.junit.Assert.*
import ru.netology.service.WallService

class WallServiceTest {

    @Test
    fun addUsers() {
        val user:Users= Users("Степан")
        val userReturn = WallService.addUsers(user)
        val result = user.id
        assertTrue(result!=0)

    }

    @Test
    fun updatePostResultFalse() {
        val service = WallService
//        service.addPost(Post(1,1,1,1,"qq"))
//        service.addPost(Post(2,1,1,1,"qq"))
        service.addPost(Post(3,1,1,1,"qq"))
        val textNew="ww"
        val result = WallService.updatePost(Post(5,1,1,1,"qq"),textNew)
        assertFalse(result)
    }

    @Test
    fun updatePostResultTrue() {
        val service = WallService
        service.addPost(Post(1,1,1,1,"qq"))
        service.addPost(Post(2,1,1,1,"qq"))
        service.addPost(Post(3,1,1,1,"qq"))
        val textNew="ww"
        val result = WallService.updatePost(Post(1,1,1,1,"qq"),textNew)
        assertTrue(result)
    }
}