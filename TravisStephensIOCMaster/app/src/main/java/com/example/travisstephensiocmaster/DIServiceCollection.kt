package com.example.travisstephensiocmaster

class DIServiceCollection {

    /**
     * This class provides the methods for intialising the DIContainer and
     * allowing registration of the objects used in the program.
     *
     * Currently the object information are stored in a list but could be
     * changed later on to use Map.
     *
     * The class also generates the container that will be used for
     * resolving the classes when needed.
     *
     * The list stores ServiceDescriptor objects
     *
     */

    var serviceDescriptorList = mutableListOf<ServiceDescriptor>()


    /**
     * Register Singleton object
     */
    fun <TService> RegisterSingleton(implementation: TService) {
        serviceDescriptorList.add(
            ServiceDescriptor(
                implementation = implementation,
                implementationType = null,
                lifetime = ServiceLifetime.SINGLETON
            )
        )
    }

    /**
     * Register Singleton object using Generics
     */
    inline fun <reified T> RegisterSingleton() {
        serviceDescriptorList.add(
            ServiceDescriptor(
                implementation = null,
                implementationType = null,
                lifetime = ServiceLifetime.SINGLETON,
                clazz = T::class
            )
        )
    }

    /**
     * Registering transient object using generics
     */
    inline fun <reified T> RegisterTransient() {
        serviceDescriptorList.add(
            ServiceDescriptor(
                implementation = null,
                implementationType = null,
                lifetime = ServiceLifetime.TRANSIENT,
                clazz = T::class
            )
        )
    }

    /**
     * Registering interface and the implementation object
     */
    inline fun <reified TService, reified Implementation> RegisterInterface() {
        serviceDescriptorList.add(
            ServiceDescriptor(
                implementation = null,
                implementationType = Implementation::class,
                lifetime = ServiceLifetime.TRANSIENT,
                clazz = TService::class
            )
        )
    }


    /**
     * Generate DIContainer and pass it the list of ServiceDescriptors
     */
    fun GenerateContainer(): DIContainer {
        return DIContainer(serviceDescriptorList)
    }
}