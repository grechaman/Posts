package ru.netology

import ru.netology.attachments.Attachments
import java.util.Calendar.*

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int?,
    val date: Long = getInstance().timeInMillis,
    val text: String?,
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
    val arrayAttachments: Array<Attachments>?,
    val comment: Comment? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavorite != other.isFavorite) return false
        if (postponedId != other.postponedId) return false
        if (arrayAttachments != null) {
            if (other.arrayAttachments == null) return false
            if (!arrayAttachments.contentEquals(other.arrayAttachments)) return false
        } else if (other.arrayAttachments != null) return false
        if (comment != other.comment) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + (fromId ?: 0)
        result = 31 * result + date.hashCode()
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + replyOwnerId
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + postponedId
        result = 31 * result + (arrayAttachments?.contentHashCode() ?: 0)
        result = 31 * result + (comment?.hashCode() ?: 0)
        return result
    }
}