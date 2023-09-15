package com.hamza.deutschebank.features.users

import com.hamza.deutschebank.core.domain.ApiResult
import com.hamza.deutschebank.core.domain.ErrorType
import com.hamza.deutschebank.core.domain.Error
import com.hamza.deutschebank.data.users.domain.Users
import com.hamza.deutschebank.data.users.domain.UsersData
import com.hamza.deutschebank.data.users.services.UserService
import com.hamza.deutschebank.domain.usecases.users.UsersUseCase
import com.hamza.deutschebank.domain.usecases.users.UsersUseCaseImpl
import com.hamza.deutschebank.framework.AppBaseTest
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UsersUseCaseTest : AppBaseTest() {

    lateinit var useCase: UsersUseCase

    @Mock
    lateinit var UserserviceMock: UserService

    @Before
    fun execute() {
        super.setUpBase()
        useCase = UsersUseCaseImpl(UserserviceMock)
    }

    @Test
    fun testGetUsersSuccess() = runBlocking {
        //when
        whenever(UserserviceMock.getUsers()).thenReturn(getMockUsersResultSuccess())

        //then
        val result = useCase.execute()

        //assert
        assertFalse(result is UsersUseCase.Result.Error)
        assertTrue(result is UsersUseCase.Result.Success)
    }

    @Test
    fun testGetUsersError() = runBlocking {

        //when
        whenever(UserserviceMock.getUsers()).thenReturn(ApiResult(error = Error("code", "message", ErrorType.GENERIC)))

        //then
        val result = useCase.execute()

        //assert
        assertFalse(result is UsersUseCase.Result.Success)
        assertTrue(result is UsersUseCase.Result.Error)
    }


    private fun getMockUsersResultSuccess(): ApiResult<UsersData> {
        return ApiResult(
            httpStatusCode = 200,
            serverDate = null,
            response = getMockUsersResponse(),
            error = null
        )
    }

    private fun getMockUsersResponse() = UsersData(
        listOf(
            Users(
                id = 1,
                name = "abc",
                username = "previewURL",
                email = "userImageURL",
                phone = "userImageURL",
                street = "userImageURL",
                suite = "userImageURL",
                city = "userImageURL",
                company = "userImageURL"
            )
        )
    )
}