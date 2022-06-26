package ru.netology.attachments

class Video(title: String, player: String, id: Int, ownerId: Int)

class AttachmentsVideo(override var type: String = "video", override val id: Int, override val ownerId: Int, val video: Video):
    Attachments(type,id,ownerId)