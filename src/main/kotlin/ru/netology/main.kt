package ru.netology

import ru.netology.attachments.*
import ru.netology.service.WallService
import java.util.*

fun main() {
    val user1 = WallService.addUsers(Users("Стас"))
    val user2 = WallService.addUsers(Users("Николай"))
    val user3 = WallService.addUsers(Users("Вячеслав"))
    var arrayMusic = emptyArray<Audio>()
    arrayMusic += Audio("Jungle", "Freeway", 39)
    arrayMusic += Audio("Chunky", "Format:B", 93)
    arrayMusic += Audio("Perfect", "Ed Sheeran", 54)
    var arrayAttachments = emptyArray<Attachments>()
    arrayAttachments += AttachmentsAudio(id = 15, ownerId = 1, audio = arrayMusic[0])
    arrayAttachments += AttachmentsAudio(id = 16, ownerId = 2, audio = arrayMusic[1])
    arrayAttachments += AttachmentsAudio(id = 17, ownerId = 3, audio = arrayMusic[2])
    arrayAttachments += AttachmentsVideo(id=18, ownerId = 1, video = Video("Прыжок веры","YouTube",99,4))

    val post1 = WallService.addPost(
        Post(
            ownerId = user1.id,
            fromId = user2.id,
            text = "Наконец мы добрались до ООП и можем уже не только решать вычислительные задачи, но и моделировать целые системы.",
            arrayAttachments = null
        )
    )
    val post2 = WallService.addPost(
        Post(
            ownerId = user3.id,
            fromId = user1.id,
            text = "Теперь нужно разобраться с функциональностью сервиса, отвечающего за стены пользователей",
            arrayAttachments = null
        )
    )
    val post3 = WallService.addPost(
        Post(
            ownerId = user2.id,
            fromId = user3.id,
            text = "Для работы с любыми типами вам вполне могут понадобиться методы и операторы из тех",
            arrayAttachments = arrayAttachments
        )
    )

    val status = WallService.updatePost(
        post2, "Повторяю НЕТ ВОЙНЕ 100000 раз https://www.youtube.com/watch?v=8yuhjZ_n9tI"
    )
    println(status)
    WallService.createComment(1, Comment("Dr.Dre",55,user1.id, Calendar.getInstance().timeInMillis,arrayAttachments[0]))

}