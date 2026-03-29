package feature.comment.domain.entity

data class CommentWithStatus(
    val comment: Comment,
    val isRead: Boolean,
)
