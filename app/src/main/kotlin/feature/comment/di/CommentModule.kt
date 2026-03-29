package feature.comment.di

import base.domain.extention.factoryCastOf
import base.domain.extention.singleCalsOf
import feature.comment.data.CommentRepositoryImpl
import feature.comment.data.CommentStatusRepositoryImpl
import feature.comment.domain.repository.CommentRepository
import feature.comment.domain.repository.CommentStatusRepository
import feature.comment.domain.usecase.GetCommentsUseCase
import feature.comment.domain.usecase.GetCommentsUseCaseImpl
import feature.comment.domain.usecase.UpdateCommentReadUseCase
import feature.comment.domain.usecase.UpdateCommentReadUseCaseImpl
import feature.comment.presentation.CommentListProcessor
import feature.comment.presentation.CommentListPublisher
import feature.comment.presentation.CommentListReducer
import feature.comment.presentation.CommentListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun featureCommentModule(): Module = module {
    viewModelOf(::CommentListViewModel)
    factoryOf(::CommentListProcessor)
    factoryOf(::CommentListPublisher)
    factoryOf(::CommentListReducer)
    factoryCastOf(::GetCommentsUseCaseImpl, GetCommentsUseCase::class)
    factoryCastOf(::UpdateCommentReadUseCaseImpl, UpdateCommentReadUseCase::class)
    singleCalsOf(::CommentRepositoryImpl, CommentRepository::class)
    singleCalsOf(::CommentStatusRepositoryImpl, CommentStatusRepository::class)
}
