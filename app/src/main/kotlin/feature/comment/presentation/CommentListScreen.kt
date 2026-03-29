package feature.comment.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import base.compose.mvi.ContentState
import base.compose.theme.PreviewAppTheme
import base.compose.theme.PreviewWithThemes
import base.compose.theme.Theme
import feature.comment.domain.entity.Comment
import feature.comment.domain.entity.CommentWithStatus
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentListScreen(
    viewModel: CommentListViewModel = koinViewModel(),
) {
    val state: CommentListState by viewModel.state.collectAsState()
    Screen(state = state, processor = viewModel::process)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Screen(
    state: CommentListState,
    processor: (CommentListIntent) -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comments") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Theme.color.surface,
                    titleContentColor = Theme.color.onSurface1,
                ),
            )
        },
    ) { innerPadding ->
        Content(innerPadding = innerPadding, state = state, processor = processor)
    }
}

@Composable
private fun Content(
    innerPadding: PaddingValues,
    state: CommentListState,
    processor: (CommentListIntent) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Theme.color.background)
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedContent(
            targetState = state.contentState,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
        ) { contentState ->
            when (contentState) {
                is ContentState.Loading -> CircularProgressIndicator()
                is ContentState.Error -> Text(
                    text = "Failed to load comments",
                    color = Theme.color.error,
                )

                is ContentState.Content -> CommentList(
                    comments = state.comments,
                    processor = processor
                )
            }
        }
    }
}

@Composable
private fun CommentList(
    comments: List<CommentWithStatus>,
    processor: (CommentListIntent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        items(comments, key = { it.comment.id }) { item ->
            CommentItem(
                item = item,
                onClick = {
                    if (!item.isRead) {
                        processor(CommentListIntent.MarkAsRead(item.comment.id))
                    }
                },
            )
        }
    }
}

@Composable
private fun CommentItem(
    item: CommentWithStatus,
    onClick: () -> Unit,
) {
    val containerColor = if (item.isRead) {
        Theme.color.surface
    } else {
        Theme.color.surfaceVariant
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = item.comment.name,
                style = Theme.typography.titleSmall,
                fontWeight = if (item.isRead) FontWeight.Normal else FontWeight.Bold,
            )
            Text(
                text = item.comment.email,
                style = Theme.typography.labelSmall,
                color = Theme.color.primary,
                modifier = Modifier.padding(top = 2.dp),
            )
            Text(
                text = item.comment.body,
                style = Theme.typography.bodySmall,
                modifier = Modifier.padding(top = 6.dp),
            )
        }
    }
}

@PreviewWithThemes
@Composable
private fun ScreenPreview() {
    PreviewAppTheme {
        Screen(
            state = CommentListState(
                contentState = ContentState.Content,
                comments = listOf(
                    CommentWithStatus(
                        comment = Comment(
                            id = 1,
                            postId = 1,
                            name = "Preview comment",
                            email = "user@example.com",
                            body = "Some body text"
                        ),
                        isRead = false,
                    ),
                    CommentWithStatus(
                        comment = Comment(
                            id = 2, postId = 1,
                            name = "Read comment",
                            email = "other@example.com",
                            body = "Already read body text"
                        ),
                        isRead = true,
                    ),
                ),
            ),
        )
    }
}
