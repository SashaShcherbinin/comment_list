package feature.comment.domain.repository

import feature.comment.domain.entity.Comment
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    fun getComments(): Flow<Result<List<Comment>>>
}
