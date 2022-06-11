package ru.netology

import ru.netology.service.WallService
import java.util.Calendar.*

fun main() {
    val user1 = WallService.addUsers(Users("Стас"))
    val user2 = WallService.addUsers(Users("Николай"))
    val user3 = WallService.addUsers(Users("Вячеслав"))
    val post1 = WallService.addPost(
        Post(
            ownerId = user1.id, fromId = user2.id,
            text = "Наконец мы добрались до ООП и можем уже не только решать вычислительные задачи, но и моделировать целые системы."
        )
    )
    val post2 = WallService.addPost(
        Post(
            ownerId = user3.id, fromId = user1.id,
            text = "Теперь нужно разобраться с функциональностью сервиса, отвечающего за стены пользователей"
        )
    )
    val post3 = WallService.addPost(
        Post(
            ownerId = user2.id, fromId = user3.id,
            text = "Для работы с любыми типами вам вполне могут понадобиться методы и операторы из тех"
        )
    )

    val status = WallService.updatePost(
        post2, "Повторяю НЕТ ВОЙНЕ 100000 раз https://www.youtube.com/watch?v=8yuhjZ_n9tI"
    )
    println(status)
}