package feature.comment.data

import base.storage.common.cashe.CachePolicy
import base.storage.common.storage.LocalStorage
import feature.comment.data.dto.CommentDto
import feature.comment.data.mapper.toDomain
import feature.comment.data.service.CommentApi
import feature.comment.domain.entity.Comment
import feature.comment.domain.repository.CommentRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration.Companion.seconds

class CommentRepositoryImpl(
    private val httpClient: HttpClient,
) : CommentRepository {

    private val storage = LocalStorage<Unit, List<Comment>>(
        maxElements = 1,
        cachePolicy = CachePolicy(30.seconds),
        network = {
            httpClient.get { url(CommentApi.GET_COMMENTS) }
                .body<List<CommentDto>>()
                .map { it.toDomain() }
        },
    )

    override fun getComments(): Flow<Result<List<Comment>>> = storage.get(Unit)
}
