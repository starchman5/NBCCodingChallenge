package com.example.travisstephensioccontainer

import util.Inject

class ClassAImpl : ClassA {
    @Inject
    private val classB: ClassB? = null
    override fun printClassBName() {
        classB.printClassBName()
    }

    override fun printClassAName() {
        println(javaClass.simpleName)
    }
}