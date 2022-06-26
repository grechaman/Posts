package ru.netology.attachments

class Note(text:String,id:Int)

class AttachmentsNote(override var type: String = "note", override val id: Int, override val ownerId: Int, val note: Note):
    Attachments(type,id,ownerId)