package com.example.travisstephensioccontainer.util

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy


/**
 * Interface is used to annotate fields to be persisted by the compiler at runtime.
 * Also used to identify fields to be added in the dependency container
 */
@Target(AnnotationTarget.FIELD)
@Retention(RetentionPolicy.RUNTIME)
annotation class Inject