package feature.comment.domain.repository

import feature.comment.domain.entity.CommentId
import kotlinx.coroutines.flow.Flow

interface CommentStatusRepository {
    fun observeReadIds(): Flow<Set<CommentId>>
    suspend fun markAsRead(id: CommentId)
}
