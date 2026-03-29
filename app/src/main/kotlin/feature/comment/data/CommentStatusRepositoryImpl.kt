package feature.comment.data

import base.database.dao.ReadCommentDao
import base.database.entity.ReadCommentEntity
import feature.comment.domain.entity.CommentId
import feature.comment.domain.repository.CommentStatusRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CommentStatusRepositoryImpl(
    private val readCommentDao: ReadCommentDao,
) : CommentStatusRepository {

    override fun observeReadIds(): Flow<Set<CommentId>> =
        readCommentDao.observeAllIds().map { it.toSet() }

    override suspend fun markAsRead(id: CommentId) {
        readCommentDao.insert(ReadCommentEntity(id))
    }
}
