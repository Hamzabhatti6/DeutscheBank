package com.hamza.deutschebank.di

import com.hamza.deutschebank.data.users.services.UserService
import com.hamza.deutschebank.domain.usecases.users.UsersUseCase
import com.hamza.deutschebank.domain.usecases.users.UsersUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserUseCase(userService: UserService): UsersUseCase = UsersUseCaseImpl(userService)
}