fun sortedColumn(linesOfTwoIds: List<List<String>>, column: Int) = linesOfTwoIds.map { it[column].toInt() }.sorted()

fun abs(a: Int) = if (a >= 0) a else -a

fun sortedListToHistogram(xs: List<Int>): Map<Int, Int> {
    var elemBefore: Int? = null
    var currentElemCount = 1
    val histogram = mutableMapOf<Int, Int>()
    for (x in xs) {
        if (x == elemBefore) {
            currentElemCount++
        } else {
            if (elemBefore != null) {
                histogram[elemBefore] = currentElemCount
            }
            elemBefore = x
            currentElemCount = 1
        }
    }
    if (elemBefore != null) {
        histogram[elemBefore] = currentElemCount
    }
    return histogram.toMap()
}

fun part2(input: List<String>): Int {
    val linesOfTwoIds = input.map { line -> line.split("   ") }
    val firstColumnHistogramm = sortedListToHistogram(sortedColumn(linesOfTwoIds, 0))
    val secondColumnHistogramm = sortedListToHistogram(sortedColumn(linesOfTwoIds, 1))
    return firstColumnHistogramm.entries.fold(0) { acc, entry ->
        acc + entry.key * entry.value * (secondColumnHistogramm[entry.key] ?: 0)
    }
}

fun part1(input: List<String>): Int {
    val linesOfTwoIds = input.map { line -> line.split("   ") }
    val sortedFirstColumn = sortedColumn(linesOfTwoIds, 0)
    val sortedSecondColumn = sortedColumn(linesOfTwoIds, 1)
    return sortedFirstColumn.zip(sortedSecondColumn) { firstId: Int, secondId: Int -> abs(firstId - secondId) }.sum()
}


fun main() {
    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}


