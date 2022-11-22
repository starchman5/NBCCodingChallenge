package com.example.travisstephensioccontainer

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val container: DependencyContainer = createDependencyContainer()
        performJob(container)
    }
    private fun createDependencyContainer(): DependencyContainer {
        //Create a set of generic type classes
        val classes: MutableSet<Class<*>> = HashSet()
        classes.add(ClassAImpl::class.java)
        classes.add(ClassBImpl::class.java)
        return DependencyContainer(classes)
    }
    private fun performJob(container: DependencyContainer) {
        val classA: ClassA = container.getInstance(ClassA::class.java)!!
        val classB: ClassB = container.getInstance(ClassB::class.java)!!
        classA.printClassBName()
        classB.printClassAName()
    }
}