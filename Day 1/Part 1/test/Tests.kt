import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day1Part1Test {

    @Test
    fun testInput01() {
        assertSolutionWorks("01", 0, arrayOf())
    }

    @Test
    fun testInput02() {
        assertSolutionWorks("02", 0, arrayOf(199))
    }

    @Test
    fun testInput03() {
        assertSolutionWorks("03", 1, arrayOf(199, 200))
    }

    @Test
    fun testInput04() {
        assertSolutionWorks("04", 0, arrayOf(200, 199))
    }

    @Test
    fun testInput05() {
        assertSolutionWorks("05", 1, arrayOf(199, 200, 199))
    }

    @Test
    fun testInput06() {
        assertSolutionWorks("06", 2, arrayOf(199, 200, 201))
    }

    @Test
    fun testInput07() {
        assertSolutionWorks("07", 3, arrayOf(199, 200, 201, 202))
    }

    @Test
    fun testInput08() {
        assertSolutionWorks(
            "08", 7, arrayOf(
                199, 200, 208, 210, 200,
                207, 240, 269, 260, 263
            )
        )
    }

    @Test
    fun testInput09() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .map(String::toInt)
            .take(1000) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = measurementIncreases(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 563)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<Int>) {
        val actual = measurementIncreases(measurements)
        val formattedMeasurements = measurements.joinToString(", ", "[", "]")
        assertThat(actual)
            .withFailMessage("Test #$testNumber : Expected $expected, but was $actual. Measures provided were : $formattedMeasurements")
            .isEqualTo(expected)
    }

    private fun assertSolutionWorksWithPuzzleInputSource(actual: Int, expected: Int) {
        assertThat(actual)
            .withFailMessage("Wrong answer with data from half the puzzle input file content")
            .isEqualTo(expected)
    }

}