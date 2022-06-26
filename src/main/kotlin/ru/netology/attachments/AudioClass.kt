package ru.netology.attachments

class Audio(val name:String, val author:String,val id:Int){


}

class AttachmentsAudio(override var type: String = "audio", override val id: Int, override val ownerId: Int, val audio: Audio):
    Attachments(type,id,ownerId)