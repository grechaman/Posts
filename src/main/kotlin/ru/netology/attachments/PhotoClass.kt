package ru.netology.attachments

import java.util.*

class Photo(url:String, id:Int, ownerId:Int,date:Long = Calendar.getInstance().timeInMillis)

class AttachmentsPhoto(override var type: String = "photo", override val id: Int, override val ownerId: Int, val photo: Photo):
    Attachments(type,id,ownerId)