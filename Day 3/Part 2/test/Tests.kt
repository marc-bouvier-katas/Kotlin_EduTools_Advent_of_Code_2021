import org.junit.Assert
import org.junit.Test

class Day3Part2Test {

    @Test
    fun testInput01() {
        // Oxygen generator rating : 1 => 1
        // CO2 scrubbler rating    : 0 => 0
        assertSolutionWorks(
            "01", 0, 1, 0, arrayOf(
                "1",
                "0",
                "0"
            )
        )
    }

    @Test
    fun testInput02() {
        // Oxygen generator rating : 1 => 1
        // CO2 scrubbler rating    : 0 => 0
        assertSolutionWorks(
            "02", 0, 1, 0, arrayOf(
                "1",
                "1",
                "0"
            )
        )
    }

    @Test
    fun testInput03() {
        // Oxygen generator rating : 11 => 3
        // CO2 scrubbler rating    : 00 => 0
        assertSolutionWorks(
            "03", 0, 3, 0, arrayOf(
                "11",
                "10",
                "00",
                "10"
            )
        )
    }


    @Test
    fun testInput04() {
        // Oxygen generator rating : 11 => 3
        // CO2 scrubbler rating    : 01 => 1
        assertSolutionWorks(
            "04", 3, 3, 1, arrayOf(
                "11",
                "11",
                "01",
                "10"
            )
        )
    }

    @Test
    fun testInput05() {
        // Both equal bits for O2 & CO2
        // Oxygen generator rating : 011 => 3
        // CO2 scrubbler rating    : 110 => 6
        assertSolutionWorks(
            "05", 18, 3, 6, arrayOf(
                "000",
                "001",
                "010",
                "011",
                "100",
                "101",
                "110",
            )
        )
    }

    @Test
    fun testInput06() {
        // Oxygen generator rating : 10111 => 23
        // CO2 scrubbler rating    : 00100 => 4
        assertSolutionWorks(
            "06", 92, 23, 4, arrayOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
            )
        )
    }


    @Test
    fun testInput07() {
        // Test equal bits for CO2 measures
        // Oxygen generator rating : 10110 => 22
        // CO2 scrubbler rating    : 00111 => 7
        assertSolutionWorks(
            "07", 154, 22, 7, arrayOf(
                "00111",
                "11110",
                "10110",
                "01000",
                "10101",
            )
        )
    }

    @Test
    fun testInput08() {
        // Oxygen generator rating : 10111 => 23
        // CO2 scrubbler rating    : 01010 => 10
        assertSolutionWorks(
            "08", 230, 23, 10, arrayOf(
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
                "01010",
            )
        )
    }

    @Test
    fun testInput09() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(500) // I take half the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = decodeLifeSupportRating(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 4141528)
    }

    private fun assertSolutionWorks(
        testNumber: String,
        expectedLifeSupportRating: Int,
        expectedO2Rating: Int,
        expectedCo2Rating: Int,
        measurements: Array<String>
    ) {
        val actual = decodeLifeSupportRating(measurements)
        val formattedMeasurements = measurements.joinToString(", ", "[", "]")
        Assert.assertEquals(
            """Test #$testNumber :
                | Expected life support rating : $expectedLifeSupportRating, but was $actual.
                |   Hints : 
                |     - Expected O2 rating  : $expectedO2Rating
                |     - Expected CO2 rating : $expectedCo2Rating
                | Measures provided were : $formattedMeasurements""".trimMargin(),
            expectedLifeSupportRating,
            actual
        )
    }

    private fun assertSolutionWorksWithPuzzleInputSource(actual: Int, expected: Int) {
        Assert.assertEquals("Wrong answer with data from half the puzzle input file content", expected, actual)
    }
}