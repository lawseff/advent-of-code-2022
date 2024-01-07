package io.github.lawseff.aoclib.runner

import io.github.lawseff.aoclib.Day
import io.github.lawseff.aoclib.PartOne
import io.github.lawseff.aoclib.PartTwo
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions

class DefaultSolutionRunner : SolutionRunner {

    companion object {
        private const val INPUT_PATH_TEMPLATE = "/input/day%d/input.txt"
    }

    // TODO: refactor
    override fun run(clazz: KClass<*>) {
        val dayAnnotation = clazz.findAnnotation<Day>() ?: throw IllegalArgumentException()
        val day = dayAnnotation.value
        val input = readInputFromFile(day)

        val instance = clazz.createInstance()

        val partOneMethod = clazz.functions.firstOrNull { it.findAnnotation<PartOne>() != null }
        if (partOneMethod != null) {
             val result = partOneMethod.call(instance, input)
            println(result)
        } else {
            println()
        }

        val partTwoMethod = clazz.functions.firstOrNull { it.findAnnotation<PartTwo>() != null }
        if (partTwoMethod != null) {
            val result = partTwoMethod.call(instance, input)
            println(result)
        }
    }

    private fun readInputFromFile(day: Int): List<String> {
        val path = INPUT_PATH_TEMPLATE.format(day)
        val resourceFile = DefaultSolutionRunner::class.java.getResource(path)
            ?: return emptyList()
        val text = resourceFile.readText()
        return text.split("\n")
    }

}
