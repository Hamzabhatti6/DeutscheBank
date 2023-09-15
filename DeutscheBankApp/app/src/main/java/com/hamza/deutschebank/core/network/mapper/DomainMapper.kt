package com.hamza.deutschebank.core.network.mapper

interface DomainMapper <NetworkT, DomainT> {

    fun map(response: NetworkT) : DomainT

}