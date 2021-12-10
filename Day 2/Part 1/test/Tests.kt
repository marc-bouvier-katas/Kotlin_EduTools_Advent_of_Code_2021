import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class Day2Part1Test {

    @Test
    fun testInput01() {
        assertSolutionWorks("01", 0, arrayOf())
    }

    @Test
    fun testInput02() {
        assertSolutionWorks("02", 0, arrayOf("forward 5"))
    }

    @Test
    fun testInput03() {
        assertSolutionWorks("03", 0, arrayOf("down 5"))
    }

    @Test
    fun testInput04() {
        assertSolutionWorks("04", 1, arrayOf("forward 1", "down 1"))
    }

    @Test
    fun testInput05() {
        assertSolutionWorks("05", 10, arrayOf("forward 5", "forward 5", "down 1"))
    }

    @Test
    fun testInput06() {
        assertSolutionWorks("06", 5, arrayOf("forward 1", "down 5"))
    }

    @Test
    fun testInput07() {
        assertSolutionWorks("07", 0, arrayOf("forward 1", "down 5", "up 5"))
    }

    @Test
    fun testInput08() {
        assertSolutionWorks("08", 25, arrayOf("down 5", "forward 5"))
    }

    @Test
    fun testInput09() {
        assertSolutionWorks("09", 5, arrayOf("down 5", "up 4", "forward 5"))
    }

    @Test
    fun testInput10() {

        assertSolutionWorks(
            "10", 150, arrayOf(
                "forward 5", "down 5", "forward 8",
                "up 3", "down 8", "forward 2",
            )
        )
    }

    @Test
    fun testInput11() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(500) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = pilotSubmarine(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 435335)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<String>) {
        val actual = pilotSubmarine(measurements)
        val formattedMeasurements = measurements.joinToString(", ", "[", "]")
        assertThat(actual)
            .withFailMessage("Test #$testNumber : Expected $expected, but was $actual. Measures provided were : $formattedMeasurements")
            .isEqualTo(expected)
    }

    private fun assertSolutionWorksWithPuzzleInputSource(actual: Int, expected: Int) {
        Assertions.assertThat(actual)
            .withFailMessage("Wrong answer with data from half the puzzle input file content")
            .isEqualTo(expected)
    }
}