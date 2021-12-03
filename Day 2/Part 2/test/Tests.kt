import org.junit.Assert
import org.junit.Test

class Day2Part2Test {

    @Test
    fun testInput01() {
        assertSolutionWorks("01", 0, arrayOf())
    }

    @Test
    fun testInput02() {
        assertSolutionWorks("02", 25, arrayOf("down 1", "forward 5"))
    }

    @Test
    fun testInput03() {
        assertSolutionWorks("03", 50, arrayOf("down 2", "forward 5"))
    }

    @Test
    fun testInput04() {
        assertSolutionWorks("04", 36, arrayOf("down 1", "forward 5", "forward 1"))
    }

    @Test
    fun testInput05() {
        assertSolutionWorks("05", 0, arrayOf("down 1", "up 1", "forward 5"))
    }


    @Test
    fun testInput06() {
        assertSolutionWorks("06", 150, arrayOf("down 1", "forward 5", "down 1", "forward 5"))
    }

    @Test
    fun testInput07() {
        assertSolutionWorks("07", 0, arrayOf("down 10", "forward 10", "up 20", "forward 10"))
    }

    @Test
    fun testInput08() {
        assertSolutionWorks("08", 0, arrayOf("forward 10", "down 10"))
    }

    @Test
    fun testInput09() {
        assertSolutionWorks("09", 1000, arrayOf("down 10", "forward 10"))
    }

    @Test
    fun testInput10() {
        assertSolutionWorks("10", 500, arrayOf("down 10", "up 5", "forward 10"))
    }

    @Test
    fun testInput11() {
        assertSolutionWorks("11", 900, arrayOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"))
    }

    @Test
    fun testInput12() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(500) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = pilotSubmarine(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 222935578)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<String>) {
        val actual = pilotSubmarine(measurements)
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