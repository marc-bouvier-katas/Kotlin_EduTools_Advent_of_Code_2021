import org.junit.Assert
import org.junit.Test

class Day3Part1Test {

    @Test
    fun testInput01() {
        // Gamma   = 1 => 1
        // Epsilon = 0 => 0
        assertSolutionWorks(
            "01", 0, arrayOf(
                "0",
                "1",
                "1"
            )
        )
    }

    @Test
    fun testInput02() {
        // Gamma   = 0 => 0
        // Epsilon = 1 => 1
        assertSolutionWorks(
            "02", 0, arrayOf(
                "0",
                "0",
                "1"
            )
        )
    }

    @Test
    fun testInput03() {
        // Gamma   = 10 => 2
        // Epsilon = 01 => 1
        assertSolutionWorks(
            "03", 2, arrayOf(
                "01",
                "10",
                "10"
            )
        )
    }

    @Test
    fun testInput04() {
        // Gamma   = 10110 => 22
        // Epsilon = 01001 => 9
        assertSolutionWorks(
            "04", 198, arrayOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
            )
        )
    }

    @Test
    fun testInput05() {
        // Gamma   = 000000000001 => 1
        // Epsilon = 111111111110 => 4094
        //       >2048 >128    8
        assertSolutionWorks(
            "06", 4094, arrayOf(
                "000000000000",
                "111111111111",
                "000000000001"
            )
        )
    }


    @Test
    fun testInput06() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(500) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = decodePowerConsumption(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 4192166)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<String>) {
        val actual = decodePowerConsumption(measurements)
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