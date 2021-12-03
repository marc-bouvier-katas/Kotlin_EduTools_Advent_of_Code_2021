import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day1Part2Test {

    @Test
    fun testInput01() {
        assertSolutionWorks("01", 0, arrayOf(199, 200, 208))
    }

    @Test
    fun testInput02() {
        assertSolutionWorks("02", 1, arrayOf(199, 200, 208, 210))
    }

    @Test
    fun testInput03() {
        assertSolutionWorks("03", 0, arrayOf(199, 200, 208, 199))
    }

    @Test
    fun testInput04() {
        assertSolutionWorks("04", 1, arrayOf(199, 200, 208, 210, 200))
    }

    @Test
    fun testInput05() {
        assertSolutionWorks("05", 2, arrayOf(199, 200, 208, 210, 200, 207, 240))
    }

    @Test
    fun testInput06() {
        assertSolutionWorks("06", 5, arrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))
    }

    @Test
    fun testInput07() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .map(String::toInt)
            .take(1000) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = increasesInSlidingWindow(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 552)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<Int>) {
        val actual = increasesInSlidingWindow(measurements)
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