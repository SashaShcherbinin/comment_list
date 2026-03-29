package feature.comment.data.mapper

import feature.comment.data.dto.CommentDto
import feature.comment.domain.entity.Comment

fun CommentDto.toDomain(): Comment = Comment(
    id = id,
    postId = postId,
    name = name,
    email = email,
    body = body,
)
