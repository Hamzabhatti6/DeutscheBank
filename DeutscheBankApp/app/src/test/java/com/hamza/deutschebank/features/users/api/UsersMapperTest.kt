package com.hamza.deutschebank.features.users.api

import com.hamza.deutschebank.data.users.network.mappers.UsersMapper
import com.hamza.deutschebank.data.users.network.response.UsersOTO
import com.hamza.deutschebank.framework.AppBaseTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UsersMapperTest : AppBaseTest() {

    private lateinit var usersMapper: UsersMapper

    @Before
    fun setUp() {
        super.setUpBase()
        usersMapper = UsersMapper()
    }

    @Test
    fun testUsersMapperSuccess() {
        //given
        val usersList = listOf(
            UsersOTO(
                id=1,
                name = "user-1",
                username = "username-1",
                email = "",
                phone = "",
                website = "",
                address= null,
                company= null,
            ),
            UsersOTO(
                id=2,
                name = "user-2",
                username = "username-2",
                email = "",
                phone = "",
                website = "",
                address= null,
                company= null,
            ),
            UsersOTO(
                id=3,
                name = "user-3",
                username = "username-3",
                email = "",
                phone = "",
                website = "",
                address= null,
                company= null,
            ),
            UsersOTO(
                id=4,
                name = "user-4",
                username = "username-4",
                email = "",
                phone = "",
                website = "",
                address= null,
                company= null,
            )
        )


        //when
        val result = usersMapper.map(usersList)

        //assert
        assertTrue(result.usersList?.isNotEmpty() == true)
        assertEquals(result.usersList?.size, 4)
        assertEquals(result.usersList?.get(0)?.id, 1)
        assertEquals(result.usersList?.get(1)?.name, "user-2")
        assertEquals(result.usersList?.get(2)?.username, "username-3")
    }
}