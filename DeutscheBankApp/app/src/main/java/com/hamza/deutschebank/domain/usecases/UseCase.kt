package com.hamza.deutschebank.domain.usecases

interface UseCase<InputT, OutputT> {

    suspend fun execute(): OutputT
}