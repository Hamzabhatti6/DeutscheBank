package com.hamza.deutschebank.domain.usecases.users

import com.hamza.deutschebank.data.users.domain.UsersData
import com.hamza.deutschebank.domain.usecases.UseCase

interface UsersUseCase: UseCase<UsersUseCase, UsersUseCase.Result> {

    sealed class Result {
        data class Success(val Users: UsersData) : Result()
        data class Error(val message: String) : Result()
    }
}