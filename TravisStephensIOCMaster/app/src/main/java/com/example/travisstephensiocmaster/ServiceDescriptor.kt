package com.example.travisstephensiocmaster

import kotlin.reflect.KClass

data class ServiceDescriptor(
    var implementation: Any?,
    var implementationType: KClass<*>?,
    var lifetime: ServiceLifetime,
    var clazz: KClass<*>? = implementation?.let { it::class }
)
