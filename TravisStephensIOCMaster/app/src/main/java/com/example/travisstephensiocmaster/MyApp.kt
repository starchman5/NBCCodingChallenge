package com.example.travisstephensiocmaster


import com.example.travisstephensiocmaster.testclasses.*
import com.example.travisstephensiocmaster.testclasses.datasource.DataSource
import com.example.travisstephensiocmaster.testclasses.datasource.DataSourceImpl
import com.example.travisstephensiocmaster.testclasses.network.UuidApiService
import com.example.travisstephensiocmaster.testclasses.network.UuidApiServiceImpl
import com.example.travisstephensiocmaster.testclasses.repository.Repository
import com.example.travisstephensiocmaster.testclasses.repository.RepositoryImpl


fun main(args: Array<String>) {
    /**
     * The main entry point to the program.
     *
     * Initialises the DI Services and providing the container and then contains code for 4 tests
     */

    var services = DIServiceCollection()
    var container = services.GenerateContainer()
    //Test 1 USING RandomGuidGenerator class and GETTING singleton RESULT should be same uuid
    test1(services, container)

    //Test 2 USING RandomGuidGenerator class and GETTING transient RESULT should be different uuid
    //test2(services, container)

    //Test 3 USING testclasses.datasource.DataSource and DatasourceImpl class and GETTING transient Should be able to use interface and get implementation
    //RESULT should be different uuid
    //test3(services, container)

    //Test 4 USING testclasses.repository.Repository and testclasses.repository.RepositoryImpl class and GETTING transient Should be able to create object and pass in dependency through constructor
    //RESULT
    //test4(services, container)
}


fun test1(services: DIServiceCollection, container: DIContainer) {
//    //Test 1
//    //USING RandomGuidGenerator class and GETTING singleton
//    //RESULT should be same uuid
//

    println("=====TEST 1======")
    services.RegisterSingleton<GuidStore>()
    var service1 = container.resolveService<GuidStore>()
    var service2 = container.resolveService<GuidStore>()

    println(service1?.getUuid())
    println(service2?.getUuid())
}

fun test2(services: DIServiceCollection, container: DIContainer) {
//Test 2
    //USING RandomGuidGenerator class and GETTING transient
    //RESULT should be different uuid

    println("/n=====TEST 2======")
    services.RegisterTransient<GuidStore>()
    var service1 = container.resolveService<GuidStore>()
    var service2 = container.resolveService<GuidStore>()

    println(service1?.getUuid())
    println(service2?.getUuid())
}


fun test3(services: DIServiceCollection, container: DIContainer) {
    //Test 3
    //USING testclasses.datasource.DataSource and DatasourceImpl class and GETTING transient
    //Should be able to use interface and get implementation
    //RESULT should be different uuid

    println("/n=====TEST 3======")
    services.RegisterInterface<DataSource, DataSourceImpl>()
    var service1 = container.resolveService<DataSource>()
    var service2 = container.resolveService<DataSource>()

    service1?.printSomething()
    service2?.printSomething()

}

fun test4(services: DIServiceCollection, container: DIContainer) {
    //Test 4
    //USING testclasses.repository.Repository and testclasses.repository.RepositoryImpl class and GETTING transient
    //Should be able to create object and pass in dependency through constructor
    //RESULT

    println("/n=====TEST 4======")
    services.RegisterTransient<GuidStore>()
    services.RegisterInterface<Repository, RepositoryImpl>()
    services.RegisterInterface<UuidApiService, UuidApiServiceImpl>()
    var service1 = container.resolveService<Repository>()

    println("printing using testclasses.network.UuidApiService: ${service1?.printUuidUsingUuidApiService()}")
    println("printing using testclasses.GuidStore: ${service1?.printUuidUsingGuidStore()}")

}