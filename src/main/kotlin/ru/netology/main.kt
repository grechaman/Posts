package ru.netology

import java.util.Calendar.*
import kotlin.random.Random

var counter = 1

data class Users(
    val names: String,
    val id: Int = Random.nextInt(1000)
)

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Long,
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
//    val comments: Objects,
//    val copyright: Objects,
//    val likes: Objects,
//    val reposts: Objects,
//    val views: Objects,
//    val postType: String,
//    val signerId: Int,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
//    val donut: Objects,
    val postponedId: Int = 0,
)

object WallService {
    private var posts = emptyArray<Post>()
    private var users = emptyArray<Users>()

    fun createPost(userCreator: Users, userPostWall: Users = userCreator, text: String): Post {
        val post = Post(counter, userCreator.id, userPostWall.id, getInstance().timeInMillis, text)
        counter += 1
        addPost(post)
        return post
    }

    fun addPost(post: Post) {
        posts += post
    }

    fun addUsers(user: Users): Users {
        users += user
        return users.last()
    }

    fun updatePost(id: Int, newText: String): Boolean {
        posts.forEachIndexed { index, postElement ->
            if (id == postElement.id) {
                posts[index] = postElement.copy(text = newText)
                return true
            }
        }
        return false
    }
}

fun main() {
    val user1 = WallService.addUsers(Users("Стас"))
    val user2 = WallService.addUsers(Users("Николай"))
    val user3 = WallService.addUsers(Users("Вячеслав"))
    val post1 = WallService.createPost(
        user1,
        text = "Наконец мы добрались до ООП и можем уже не только решать вычислительные задачи, но и моделировать целые системы."
    )
    val post2 = WallService.createPost(
        user2, user1,
        text = "Теперь нужно разобраться с функциональностью сервиса, отвечающего за стены пользователей"
    )
    val post3 = WallService.createPost(
        user3, user2,
        text = "Для работы с любыми типами вам вполне могут понадобиться методы и операторы из тех"
    )
    val status =
        WallService.updatePost(2, "Повторяю НЕТ ВОЙНЕ 100000 раз https://www.youtube.com/watch?v=8yuhjZ_n9tI")
    println(status)
}