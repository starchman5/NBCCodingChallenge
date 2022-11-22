package com.example.travisstephensioccontainer

import util.Inject

/**
 * Class is used to initialise and provide instances with dependencies to the application
 */
class DependencyContainer(serviceClasses: Collection<Class<*>>) {
    private val dependencies: MutableSet<Any> = HashSet()

    /**
     * Function instantiates all classes defined in the project
     */
    @Throws(Exception::class)
    private fun initDependencies(classes: Collection<Class<*>>) {
        //Instantiate the classes using default (compiler) constructor
        for (clazz in classes) {
            val constructor = clazz.getConstructor()
            constructor.isAccessible = true
            dependencies.add(constructor.newInstance())
        }

        //Check if the class has any fields as dependencies
        for (instance in dependencies) {
            for (field in instance.javaClass.declaredFields) {

                //Check for the @util.Inject annotation field to screen out Integer and String classes
                if (!field.isAnnotationPresent(Inject::class.java)) {
                    // this field is none of our business
                    continue
                }
                //Check each field type
                val fieldType = field.type
                //Access private fields
                field.isAccessible = true

                //Check the instances set for any matches
                for (matchingType in dependencies) {
                    if (fieldType.isInstance(matchingType)) {
                        //Initialise the field with the matching type
                        field[instance] = matchingType
                    }
                }
            }
        }
    }

    /**
     * Function takes in a class parameter
     * and attempts to return an instance of that type
     * @param clazz
     */
    fun <T> getInstance(clazz: Class<T>): T? {
        for (dependency in dependencies) {
            if (clazz.isInstance(dependency)) {
                return dependency as T
            }
        }
        //No match was found
        return null
    }

    init {
        try {
            initDependencies(serviceClasses)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}