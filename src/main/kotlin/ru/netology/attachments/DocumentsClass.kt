package ru.netology.attachments

class Documents(title:String,id:Int, ownerId: Int, size:Int, ext:String)

class AttachmentsDocuments(override var type: String = "doc", override val id: Int, override val ownerId: Int, val documents: Documents):
    Attachments(type,id,ownerId)