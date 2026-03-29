package feature.comment.domain.usecase

import feature.comment.domain.entity.CommentId
import feature.comment.domain.repository.CommentStatusRepository

interface UpdateCommentReadUseCase : suspend (CommentId) -> Unit

class UpdateCommentReadUseCaseImpl(
    private val commentStatusRepository: CommentStatusRepository,
) : UpdateCommentReadUseCase {

    override suspend fun invoke(id: CommentId) {
        commentStatusRepository.markAsRead(id)
    }
}
