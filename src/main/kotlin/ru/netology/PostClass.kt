package ru.netology

import java.util.Calendar.*

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val date: Long = getInstance().timeInMillis,
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