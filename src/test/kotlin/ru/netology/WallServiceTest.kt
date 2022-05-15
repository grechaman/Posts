package ru.netology

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun createPostUserPostWallDefault() {
        val userCreator: Users = Users("Степан")
        val text: String = "123"
        val post = WallService.createPost(userCreator, text = text)
        val result = post.id
        assert(result!=0)
    }

    @Test
    fun createPostUserPostWallNonDef() {
        val userCreator: Users = Users("Степан")
        val userPostWall: Users = Users("Николай")
        val text: String = "123"
        val post = WallService.createPost(userCreator, userPostWall, text = text)
        val result = post.id
        assert(result!=0)
    }

    @Test
    fun addUsers() {
        val user:Users= Users("Степан")
        val userReturn = WallService.addUsers(user)
        val result = user.id
        assert(result!=0)

    }

    @Test
    fun updatePostResultFalse() {
        val service = WallService
        service.addPost(Post(1,1,1,1,"qq"))
        service.addPost(Post(2,1,1,1,"qq"))
        service.addPost(Post(3,1,1,1,"qq"))
        val textNew="ww"
        val result = WallService.updatePost(4,textNew)
        assertFalse(result)
    }

    @Test
    fun updatePostResultTrue() {
        val service = WallService
        service.addPost(Post(1,1,1,1,"qq"))
        service.addPost(Post(2,1,1,1,"qq"))
        service.addPost(Post(3,1,1,1,"qq"))
        val textNew="ww"
        val result = WallService.updatePost(2,textNew)
        assertTrue(result)
    }
}