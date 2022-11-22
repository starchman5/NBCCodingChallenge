package com.example.travisstephensiocmaster.testclasses.network

import java.util.*

interface UuidApiService {
    fun getUuid(): UUID
}

class UuidApiServiceImpl(): UuidApiService {
    override fun getUuid(): UUID {
        return UUID.randomUUID()
    }
}