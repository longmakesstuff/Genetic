package de.longuyen.drawing.shape

import java.util.*

class StochasticSelector : Selector {
    val random = Random()

    // given a sorted list of individuals select individuals with a decreasing probability of
    // rand(0, 1) < (n - i)/(n + 1) where n is the size of the population and i is the ith individual.
    // i = 0 is the most fit
    // always leave at least one individual
    override fun select(population: List<Chromosome>): Chromosome {
        val bias = population.size * 0.6
        var i = 0
        population.forEach { individual ->
            if (i > 0) {
                if (random.nextDouble() <= (population.size - i) / (population.size.toDouble() + bias)) {
                    return individual
                }
            }
            i++
        }
        return population.first()
    }
}