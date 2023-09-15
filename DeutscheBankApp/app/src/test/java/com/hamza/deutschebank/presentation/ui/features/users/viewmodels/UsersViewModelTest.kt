package com.hamza.deutschebank.presentation.ui.features.users.viewmodels

import com.hamza.deutschebank.data.users.domain.Users
import com.hamza.deutschebank.data.users.domain.UsersData
import com.hamza.deutschebank.domain.usecases.users.UsersUseCase
import com.hamza.deutschebank.framework.ViewModelBaseTest
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals

class UsersViewModelTest: ViewModelBaseTest() {

    private lateinit var viewModel: UsersViewModel

    @Mock
    lateinit var useCase: UsersUseCase

    @Before
    fun setUp() {
        super.setUpBase()
        viewModel = UsersViewModel(useCase)
    }

    @Test
    fun testGetUsers() = runBlocking {
        //when
        whenever(useCase.execute()).thenReturn(UsersUseCase.Result.Success(getMockUsersResponse()))

        //then
        viewModel.getUsers()

        // Assert
        assertEquals(false, viewModel.showLoader.value)
        assertEquals(getMockUsersResponse(), viewModel.usersList.value)
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