package day04


import utils.println
import utils.readInput
import kotlin.math.min


class CharSquareMatrix(val matrix: List<List<Char>>, val size: Int)

fun stringTo2DArray(input: List<String>): CharSquareMatrix {
    val content = input.map { it.toList() }
    return CharSquareMatrix(content, content.size)
}

//
//
fun rightDownFrom(startX: Int, startY: Int, matrix: CharSquareMatrix) =
    (0..min(matrix.size - startX - 1, matrix.size - startY - 1)).map { matrix.matrix[startX + it][startY + it] }


fun rightDownDiagonals(matrix: CharSquareMatrix): List<List<Char>> =
    (0..<matrix.size).map { rightDownFrom(0, it, matrix) } + (1..<matrix.size).map { rightDownFrom(it, 0, matrix) }

fun diagonals(matrix: CharSquareMatrix): List<List<Char>> =
    rightDownDiagonals(matrix) + rightDownDiagonals(CharSquareMatrix(matrix.matrix.map { it.reversed() }, matrix.size))


fun columns(matrix: CharSquareMatrix): List<List<Char>> =
    (0..<matrix.size).map { row -> (0..<matrix.size).map { column -> matrix.matrix[column][row] } }
//diagonals(matrix) + (matrix.matrix) +

fun rowsColumnsDiagonals(matrix: CharSquareMatrix): List<String> =
    (diagonals(matrix) + columns(matrix) + matrix.matrix).map { it.joinToString("") }

val test2DCharList = listOf(listOf('a', 'b', 'c'), listOf('d', 'e', 'f'), listOf('g', 'h', 'i'))
val testMatrix = CharSquareMatrix(test2DCharList, 3)


val test2DCharList2 = listOf(
    listOf('a', 'b', 'c', 'd'),
    listOf('e', 'f', 'g', 'h'),
    listOf('i', 'j', 'k', 'l'),
    listOf('m', 'n', 'o', 'p')
)
val testMatrix2 = CharSquareMatrix(test2DCharList2, 4)
//
//fun diagonalsRightDown(matrix:List<List<Char>>) = _
//
//
//fun part1(input: String): Int {
//
//
//}

fun get3x3SubMatrix(matrix: CharSquareMatrix, leftUpperX: Int, leftUpperY: Int): List<List<Char>> =
    matrix.matrix.slice(leftUpperY..leftUpperY + 2).map { row -> row.slice(leftUpperX..leftUpperX + 2) }

fun get3x3SubMatrices(matrix: CharSquareMatrix): List<List<List<Char>>> =
    (0..matrix.size - 3).map { row -> (0..matrix.size - 3).map { column -> get3x3SubMatrix(matrix, row, column) } }
        .flatten()

fun pointsOf3x3Matrix(matrix: List<List<Char>>): Int {
    var acc = 0
//    if (matrix[0][1] == 'M' && matrix[1][0] == 'M'  && matrix[1][1] == 'A' && matrix[1][2] == 'S' && matrix[2][1] == 'S') {
//        acc += 1
//    }
//    if (matrix[0][1] == 'S' && matrix[1][0] == 'S' && matrix[1][1] == 'A' && matrix[1][2] == 'M' && matrix[2][1] == 'M') {
//        acc += 1
//    }
//    if (matrix[0][1] == 'S' && matrix[1][0] == 'M' && matrix[1][1] == 'A' && matrix[1][2] == 'S' && matrix[2][1] == 'M') {
//        acc += 1
//    }
//    if (matrix[0][1] == 'M' && matrix[1][0] == 'S' && matrix[1][1] == 'A' && matrix[1][2] == 'M' && matrix[2][1] == 'S') {
//        acc += 1
//    }


    if (matrix[0][0] == 'M' && matrix[0][2] == 'M' && matrix[1][1] == 'A' && matrix[2][0] == 'S' && matrix[2][2] == 'S') {
        acc += 1
    }

    if (matrix[0][0] == 'S' && matrix[0][2] == 'S' && matrix[1][1] == 'A' && matrix[2][0] == 'M' && matrix[2][2] == 'M') {
        acc += 1
    }


    if (matrix[0][0] == 'M' && matrix[0][2] == 'S' && matrix[1][1] == 'A' && matrix[2][0] == 'M' && matrix[2][2] == 'S') {
        acc += 1
    }

    if (matrix[0][0] == 'S' && matrix[0][2] == 'M' && matrix[1][1] == 'A' && matrix[2][0] == 'S' && matrix[2][2] == 'M') {
        acc += 1
    }
    return acc




}


fun part1(input: List<String>): Int {
    val matrix = stringTo2DArray(input)
    return rowsColumnsDiagonals(matrix).map { it.windowed(4) }.flatten()
        .count { it == "XMAS" || it == "SAMX" } //{ it.countMatches("XMAS") }.sum() + rowsColumnsDiagonals(matrix).map { it.count("SAMX") }.sum()
//    println(matrix.size)
//    matrix.forEach { row -> row.size.println()}
//    val regex = Regex("""mul\((\d+),(\d+)\)""")
//    val occurences = regex.findAll(cleanString1)
//    return  occurences.map (::occurrenceToProduct).sum()

}

fun part2(input: List<String>): Int {
    val matrix = stringTo2DArray(input)
//    println(get3x3SubMatrices(testMatrix2)//.map(::pointsOf3x3Matrix).sum()
//    )
    //get3x3SubMatrices(matrix).map(::pointsOf3x3Matrix).sum()
    return get3x3SubMatrices(matrix).map(::pointsOf3x3Matrix).sum()

}


fun main() {
    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)
    //diagonals(testMatrix).println()
    //rowsColumnsDiagonals(testMatrix).println()

//    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("day04/Day04_test")
//    part1(testInput).println()
//    check(part1(testInput) == 18)
    println(part2(testInput))
    check(part2(testInput) == 9)
//
//    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day04/Day04")
//    part1(input).println()
    //get3x3SubMatrices(testMatrix2).println()
     part2(input).println()
}


