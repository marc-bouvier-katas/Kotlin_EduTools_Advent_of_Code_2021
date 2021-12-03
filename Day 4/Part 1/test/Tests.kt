import org.junit.Assert
import org.junit.Test

class TestDay4Part1 {

    @Test
    fun testInput01() {
        assertSolutionWorks("01", 0, arrayOf())
    }

    @Test
    fun testInput12() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(500) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = doSomething(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 222935578)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<String>) {
        val actual = doSomething(measurements)
        val formattedMeasurements = measurements.joinToString(", ", "[", "]")
        Assert.assertEquals(
            "Test #$testNumber : Expected $expected, but was $actual. Measures provided were : $formattedMeasurements",
            expected,
            actual
        )
    }

    private fun assertSolutionWorksWithPuzzleInputSource(actual: Int, expected: Int) {
        Assert.assertEquals("Wrong answer with data from half the puzzle input file content", expected, actual)
    }
}