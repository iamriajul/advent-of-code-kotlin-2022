fun main() {
    fun prepare(input: List<String>): MutableList<MutableList<Int>> {
        val data = mutableListOf<MutableList<Int>>(mutableListOf())
        // Separate value into list of lists
        // They are seperated by a blank line
        for (value in input) {
            if (value.isEmpty()) {
                data.add(mutableListOf())
            } else {
                data.last().add(value.toInt())
            }
        }
        return data
    }

    fun part1(input: List<String>): Int {
        val data = prepare(input)
        return data.maxOf { it.sum() }
    }

    fun part2(input: List<String>): Int {
        val data = prepare(input)
        return data
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
