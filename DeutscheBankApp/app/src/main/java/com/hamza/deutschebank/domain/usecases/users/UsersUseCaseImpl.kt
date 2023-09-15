package com.hamza.deutschebank.domain.usecases.users

import com.hamza.deutschebank.core.utils.isSuccess
import com.hamza.deutschebank.data.users.services.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersUseCaseImpl @Inject constructor(
    private val userService: UserService
): UsersUseCase {

    override suspend fun execute(): UsersUseCase.Result {
        return withContext(Dispatchers.IO) {
            val result = userService.getUsers()
            if (result.isSuccess()) {
                val response = result.response
                if (response != null) {
                    UsersUseCase.Result.Success(result.response)
                } else UsersUseCase.Result.Error("Response is empty")
            } else {
                UsersUseCase.Result.Error(result.error?.errorMessage ?: "")
            }
        }
    }
}