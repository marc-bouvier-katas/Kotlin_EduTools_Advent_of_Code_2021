import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestDay5Part1 {

    @Test
    fun testInput01() {
        val input = arrayOf<String>()
        assertSolutionWorks("01", 0, input)
    }

    @Test
    fun testInput12_sample_input() {
        val input = arrayOf(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2",
        )
        assertSolutionWorks("12", 5, input)
    }

    @Test
    fun testInput12_final_acceptance() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(249) // I take a small part of the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = numberOfPointsWhereAtLeastTwoLinesOverlaps(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 1298)
    }

    private fun assertSolutionWorks(
        testNumber: String,
        expected: Int,
        measurements: Array<String>
    ) {
        val actual = numberOfPointsWhereAtLeastTwoLinesOverlaps(measurements)
        val formattedInputs = measurements.joinToString("\n")
        Assert.assertEquals(
            "Test #$testNumber : Expected score $expected, but was $actual. Inputs provided were : \n$formattedInputs",
            expected,
            actual
        )
    }

    private fun assertSolutionWorksWithPuzzleInputSource(
        actual: Int,
        expected: Int
    ) {
        Assert.assertEquals(
            "Wrong answer with data from half of the puzzle input file content. Expected score $expected, but was $actual.",
            expected,
            actual
        )
    }
}