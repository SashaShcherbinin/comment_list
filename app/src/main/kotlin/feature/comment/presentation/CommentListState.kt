package feature.comment.presentation

import base.compose.mvi.ContentState
import base.compose.mvi.Effect
import base.compose.mvi.Event
import base.compose.mvi.Intent
import base.compose.mvi.State
import feature.comment.domain.entity.CommentId
import feature.comment.domain.entity.CommentWithStatus

data class CommentListState(
    val comments: List<CommentWithStatus> = emptyList(),
    val contentState: ContentState = ContentState.Loading,
) : State

sealed class CommentListIntent : Intent {
    data object Init : CommentListIntent()
    data class MarkAsRead(val id: CommentId) : CommentListIntent()
}

sealed class CommentListEffect : Effect {
    data class CommentsLoaded(val comments: List<CommentWithStatus>) : CommentListEffect()
    data class ContentStateChanged(val contentState: ContentState) : CommentListEffect()
}

sealed class CommentListEvent : Event
