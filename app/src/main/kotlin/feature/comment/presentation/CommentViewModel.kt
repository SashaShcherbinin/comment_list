@file:Suppress("OPT_IN_USAGE")

package feature.comment.presentation

import base.compose.mvi.ContentState
import base.compose.mvi.MviViewModel
import base.compose.mvi.Processor
import base.compose.mvi.Publisher
import base.compose.mvi.Reducer
import feature.comment.domain.usecase.GetCommentsUseCase
import feature.comment.domain.usecase.UpdateCommentReadUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class CommentListViewModel(
    processor: CommentListProcessor,
    reducer: CommentListReducer,
    publisher: CommentListPublisher,
) : MviViewModel<CommentListIntent, CommentListEffect, CommentListEvent, CommentListState>(
    defaultState = CommentListState(),
    processor = processor,
    reducer = reducer,
    publisher = publisher,
) {
    init {
        process(CommentListIntent.Init)
    }
}

class CommentListProcessor(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val updateCommentReadUseCase: UpdateCommentReadUseCase,
) : Processor<CommentListIntent, CommentListEffect, CommentListState> {

    override fun process(
        intent: CommentListIntent,
        state: CommentListState,
    ): Flow<CommentListEffect> = when (intent) {
        is CommentListIntent.Init -> getCommentsUseCase()
            .flatMapConcat { result ->
                result.fold(
                    onSuccess = { comments ->
                        flowOf(
                            CommentListEffect.CommentsLoaded(comments),
                            CommentListEffect.ContentStateChanged(ContentState.Content),
                        )
                    },
                    onFailure = {
                        flowOf(CommentListEffect.ContentStateChanged(ContentState.Error))
                    },
                )
            }

        is CommentListIntent.MarkAsRead -> flow {
            updateCommentReadUseCase(intent.id)
        }
    }
}

class CommentListReducer : Reducer<CommentListEffect, CommentListState> {
    override fun reduce(
        effect: CommentListEffect,
        state: CommentListState,
    ): CommentListState = when (effect) {
        is CommentListEffect.CommentsLoaded -> state.copy(comments = effect.comments)
        is CommentListEffect.ContentStateChanged -> state.copy(contentState = effect.contentState)
    }
}

class CommentListPublisher : Publisher<CommentListEffect, CommentListEvent> {
    override fun publish(effect: CommentListEffect): CommentListEvent? = null
}
