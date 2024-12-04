package day03

import  utils.*



fun occurrenceToProduct(o:MatchResult):Int{
    val (a, b) =  o.destructured;
    return a.toInt() * b.toInt()
}


fun part1(input: String): Int {
    val regex = Regex("""mul\((\d+),(\d+)\)""")
    val occurences = regex.findAll(input)
    return  occurences.map (::occurrenceToProduct).sum()

}


fun part2(input: String): Int {
    val cleanString1 = input.replaceFirst( Regex("""don't\(\)(.*?)do\(\)"""), "")

    //println(cleanString1)
    //val cleanString2 = cleanString1.substringBeforeLast("don't()")
    //println(cleanString2)
    return part1(cleanString1)
//    val regex = Regex("""mul\((\d+),(\d+)\)""")
//    val occurences = regex.findAll(cleanString1)
//    return  occurences.map (::occurrenceToProduct).sum()

}

//fun part2(input: List<String>): Int {
//    return input.map { it -> it.split(" ").map { it.toInt() } }.count(::isValidLine2)
//}


fun main() {
    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput2("day03/Day03_test")
    //check(part1(testInput) == 161)
    println(part2(testInput))
    //check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput2("day03/Day03")
    //part1(input).println()
    part2(input).println()
}


