package day02

import  utils.*




fun isValidLine(xs :List<Int>): Boolean {
    val differences = getDifferences(xs)
    return differences.all { abs(it) in 1..3 } && (differences.all{it > 0 } ||  differences.all{0 > it })
}

fun isValidLine2(xs :List<Int>): Boolean {
    val linesWithOneRemoved = List(xs.size) { index ->  xs.filterIndexed { i, _ -> index != i }}
    return (linesWithOneRemoved + listOf(xs)).any (::isValidLine)
}


private fun getDifferences(xs: List<Int>) = xs.zipWithNext { a, b -> a - b }


fun part1(input: List<String>): Int {
    return input.map { it -> it.split(" ").map { it.toInt() } }.count(::isValidLine)
}


fun part2(input: List<String>): Int {
    return input.map { it -> it.split(" ").map { it.toInt() } }.count(::isValidLine2)
}


fun main() {
    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}


