package io.github.lawseff.aoc2023.runner

import kotlin.reflect.KClass

interface SolutionRunner {

    fun run(clazz: KClass<*>)

}
