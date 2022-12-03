fun main() {
    fun part1(input: List<String>): Int {
        fun shapeScore(shape: Char): Int {
            return shape - 'X' + 1
        }

        fun resultScore(line: String): Int {
            return when (line) {
                "B X", "C Y", "A Z" -> 0
                "A X", "B Y", "C Z" -> 3
                "C X", "A Y", "B Z" -> 6
                else -> throw IllegalArgumentException("Invalid line: $line")
            }
        }

        return input.sumOf {
            shapeScore(it[2]) + resultScore(it)
        }
    }

    fun part2(input: List<String>): Int {
        fun shapeScore(line: String): Int {
            return when (line) {
                "A Y", "B X", "C Z" -> 1
                "B Y", "C X", "A Z" -> 2
                "C Y", "A X", "B Z" -> 3
                else -> throw IllegalArgumentException("Invalid line: $line")
            }
        }

        fun resultScore(shape: Char): Int {
            return (shape - 'X') * 3
        }

        return input.sumOf {
            shapeScore(it) + resultScore(it[2])
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    val testResult = part1(testInput)
    check(testResult == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
