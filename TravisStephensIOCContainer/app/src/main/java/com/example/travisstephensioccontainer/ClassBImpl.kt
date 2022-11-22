package com.example.travisstephensioccontainer

import util.Inject

class ClassBImpl : ClassB {
    @Inject
    private val classA: ClassA? = null
    override fun printClassAName() {
        classA!!.printClassAName()
    }

    override fun printClassBName() {
        println(javaClass.simpleName)
    }
}