package feature.comment.domain.usecase

import feature.comment.domain.entity.CommentWithStatus
import feature.comment.domain.repository.CommentRepository
import feature.comment.domain.repository.CommentStatusRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

interface GetCommentsUseCase : () -> Flow<Result<List<CommentWithStatus>>>

class GetCommentsUseCaseImpl(
    private val commentRepository: CommentRepository,
    private val commentStatusRepository: CommentStatusRepository,
) : GetCommentsUseCase {

    override fun invoke(): Flow<Result<List<CommentWithStatus>>> = combine(
        commentRepository.getComments(),
        commentStatusRepository.observeReadIds(),
    ) { commentsResult, readIds ->
        commentsResult.map { comments ->
            comments.map { comment ->
                CommentWithStatus(comment = comment, isRead = comment.id in readIds)
            }
        }
    }
}
