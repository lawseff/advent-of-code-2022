package io.github.lawseff.adventofcode.runner

import kotlin.reflect.KClass

interface SolutionRunner {

    fun run(clazz: KClass<*>)

}
