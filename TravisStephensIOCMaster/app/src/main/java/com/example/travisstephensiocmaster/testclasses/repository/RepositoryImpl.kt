package com.example.travisstephensiocmaster.testclasses.repository

import com.example.travisstephensiocmaster.testclasses.GuidStore
import com.example.travisstephensiocmaster.testclasses.network.UuidApiService

class RepositoryImpl(val uuidApiService: UuidApiService, val guidStore: GuidStore) : Repository {

    override fun printUuidUsingUuidApiService() {
        println(uuidApiService.getUuid())
    }

    override fun printUuidUsingGuidStore() {
        println(guidStore.getUuid())
    }
}