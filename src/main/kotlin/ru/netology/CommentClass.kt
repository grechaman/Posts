package ru.netology

import ru.netology.attachments.Attachments

data class Comment(val text: String, val id: Int, val fromId: Int, val date: Long, val attachments: Attachments?)