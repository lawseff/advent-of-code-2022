package io.github.lawseff.aoc2023.optimization

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class WinStrategyCounter {

    companion object {
        private const val MINUS_ONE = -1.0
    }

    fun countWinStrategies(race: Race): Long {
        val minDistanceToWin = race.recordDistanceMillimeters + 1
        // 1) We start with the 0 speed. Then we wait for X milliseconds, which allows us to have
        // the speed of X for the remaining of the race. The longer we wait, the higher the
        // starting speed is, but the less time we have to actually use it.
        // 2) So a winning strategy would be to wait for a relatively short amount of time X1,
        // getting a slower speed, but more time to run. Or to wait a relatively long amount of
        // time X2, thus getting a high speed, and less time to run. And all the strategies
        // in-between.
        // 3) Let's try to find a formula for X1 and X2. First, some variables
        // D - the required distance to beat the record;
        // T - the race time;
        // X1 - the shortest amount of time to wait before the start to win;
        // X2 - the longest amount of time to wait before the start to win;
        // TR - the remaining time after the waiting time.
        // The waiting time X is converted to the speed, so they are equal.
        // 4) Distance formula:
        // D = 0*X + X*TR; D = X * TR;
        // TR = T - X;
        // D = X * (T - X); D = X*T - X^2;
        // -X^2 + T*X - D = 0.
        // Now we get a quadratic equation with a = -1, b = T, C = -D.
        val times = solveQuadraticEquation(
            MINUS_ONE, race.timeMillis.toDouble(), MINUS_ONE * minDistanceToWin
        )
        // Rounding up, because at this point the passed distance growths linearly with the X.
        // If we reduce the X by rounding, the distance is less, than required.
        val minWaitingTime = ceil(times.first).toLong()
        // Rounding down, because at this point the passed distance starts decreasing linearly.
        // If we increase the X by rounding, the distance is less, than required.
        val maxWaitingTime = floor(times.second).toLong()
        val numberOfStrategies = maxWaitingTime - minWaitingTime + 1
        return numberOfStrategies
    }

    private fun solveQuadraticEquation(a: Double, b: Double, c: Double): Pair<Double, Double> {
        val discriminant = b * b - 4 * a * c
        if (discriminant < 0) {
            // No real roots
            throw IllegalArgumentException()
        }
        val root1 = (-b + sqrt(discriminant)) / (2 * a)
        val root2 = (-b - sqrt(discriminant)) / (2 * a)
        return Pair(root1, root2)
    }

}