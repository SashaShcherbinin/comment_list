package base.compose.mvi

sealed class ContentState {
    data object Content : ContentState()
    data object Loading : ContentState()
    data object Error : ContentState()
}
