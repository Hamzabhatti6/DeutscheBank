package com.hamza.deutschebank.data.users.network.mappers

import com.hamza.deutschebank.core.network.mapper.DomainMapper
import com.hamza.deutschebank.data.users.domain.Users
import com.hamza.deutschebank.data.users.domain.UsersData
import com.hamza.deutschebank.data.users.network.response.UsersOTO

class UsersMapper : DomainMapper<List<UsersOTO>, UsersData> {

    override fun map(response: List<UsersOTO>): UsersData  =
        UsersData(response.map { Users(id = it.id, name = it.name, username = it.username, email = it.email, phone = it.phone, street = it.address!!.street, suite = it.address.suite, city = it.address.city, company = it.company!!.name) })


}