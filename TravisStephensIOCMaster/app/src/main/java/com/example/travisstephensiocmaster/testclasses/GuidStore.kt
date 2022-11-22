package com.example.travisstephensiocmaster.testclasses

import java.util.*

class GuidStore {
    private lateinit var uuid: UUID

    init {
        uuid = UUID.randomUUID()
    }

    fun getUuid():UUID {
        return uuid
    }
}