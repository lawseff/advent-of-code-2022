package io.github.lawseff.aoclib.runner

import kotlin.reflect.KClass

interface SolutionRunner {

    fun run(clazz: KClass<*>)

}
