import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestDay4Part1 {

    @Test
    fun testInput01_no_winner() {
        val input = arrayOf(
            "1,6,7,8,9", // random numbers
            "",
            " 1  3", // __  3    Last drawn number : 9
            " 4  5"  //  4  5       No row or column score
        )
        assertSolutionWorks("01", 0, "\"No Winner\"", "9", input)
    }

    @Test
    fun testInput02_1_board_1_winner_from_row_1() {
        val input = arrayOf(
            "1,2", // random numbers
            "",
            " 1  2", // __ __    Last drawn number : 2
            " 3  4"  //  3  4       3 + 4 = 7
            //                      7 * 2 = 14
        )
        assertSolutionWorks("02", 14, "1", "2", input)
    }


    @Test
    fun testInput03_1_board_1_winner_from_row_2() {
        val input = arrayOf(
            "1,2", // random numbers
            "",
            " 3  4",  //  3  4    Last drawn number : 2
            " 1  2"   // __ __      3 + 4 = 7
            //                      7 * 2 = 14
        )
        assertSolutionWorks("03", 14, "1", "2", input)
    }

    @Test
    fun testInput04_1_board_1_winner_from_row_last_number_drawn_is_not_last_of_given_numbers() {
        val input = arrayOf(
            "1,3,4", // random numbers
            "",
            " 1  3", // __ __    Last drawn number : 3
            " 4  5"  //  4  5       4 + 5 = 9
            //                      9 * 3 = 27
        )
        assertSolutionWorks("04", 27, "1", "3", input)
    }

    @Test
    fun testInput05_1_board_1_winner_from_column_1() {
        val input = arrayOf(
            "1,4",
            "",
            " 1  3", // __  3    Last drawn number : 4
            " 4  5"  // __  5       3 + 5 = 8
            //                      8 * 4 = 32
        )
        assertSolutionWorks("05", 32, "1", "4", input)
    }

    @Test
    fun testInput06_1_board_1_winner_from_column_2() {
        val input = arrayOf(
            "1,4",
            "",
            " 3  1", //  3 __    Last drawn number : 4
            " 5  4"  //  5 __       3 + 5 = 8
            //                      8 * 4 = 32
        )
        assertSolutionWorks("06", 32, "1", "4", input)
    }


    @Test
    fun testInput07_1_board__1_winner_from_row_1_2_digit_numbers() {
        val input = arrayOf(
            "7,10,9",
            "",
            " 7 10", // __ __    Last drawn number : 10
            "11 12", // 11 12       11 + 12 = 23
            //                      23 * 10 = 230
        )
        assertSolutionWorks("07", 230, "1", "10", input)
    }

    @Test
    fun testInput08_1_board_3x3_one_winner_from_row() {
        val input = arrayOf(
            "1,9,5,8,2,3,10,20", // random numbers
            "",
            " 1  3  2", // __ __ __    Last drawn number : 3
            " 4  5  8", //  4 __ __       4 + 10 + 20 = 34
            " 9 10 20"  // __ 10 20       34 * 3 = 102
        )
        assertSolutionWorks("08", 102, "1", "3", input)
    }

    @Test
    fun testInput09_2_boards_3x3_one_winner_board_2_from_column() {
        val input = arrayOf(
            "1,8,14", // random numbers
            "",
            " 1  3  2", // __  3  2
            " 4  5  8", //  4  5 __
            " 9 10 20", //  9 10 20
            "",
            " 1  4  6", // __  4  6    Last drawn number : 14
            " 8 10 12", // __ 10 12       4 + 6 + 10 + 12 + 16 + 18 = 66
            "14 16 18", // __ 16 18       66 * 14 = 924
        )
        assertSolutionWorks("09", 924, "2", "14", input)
    }

    @Test
    fun testInput10_3_boards_3x3_one_winner_board_3_from_row() {
        val input = arrayOf(
            "1,3,9,8,4,2", // random numbers
            "",
            " 1  3 99", // __ __ 99
            " 4  5  8", // __  5 __
            " 7 10 20", //  7 10 20
            "",
            " 1  4  6", // __ __  6
            " 8 10 12", // __ 10 12
            "14 16 18", // 14 16 18
            "",
            " 1  2  3", // __ __ __    Last drawn number : 2
            " 4  5  6", // __  5  6       5 + 6 + 7 = 18
            " 7  8  9", //  7 __ __       18 * 2 = 36
        )
        assertSolutionWorks("10", 36, "3", "2", input)
    }


    @Test
    fun testInput10_3_boards_3x3() {
        val input = arrayOf(
            "1,3,9,8,4,2", // random numbers
            "",
            " 1  3 99", // __ __ 99
            " 4  5  8", // __  5 __
            " 7 10 20", //  7 10 20
            "",
            " 1  4  6", // __ __  6
            " 8 10 12", // __ 10 12
            "14 16 18", // 14 16 18
            "",
            " 1  2  3", // __ __ __    Last drawn number : 2
            " 4  5  6", // __  5  6       5 + 6 + 7 = 18
            " 7  8  9", //  7 __ __       18 * 2 = 36
        )
        assertSolutionWorks("10", 36, "3", "2", input)
    }


    @Test
    fun testInput11_sample_input_3_boards_5x5() {
        val input = arrayOf(
            "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
            "",
            "22 13 17 11  0",
            " 8  2 23  4 24",
            "21  9 14 16  7",
            " 6 10  3 18  5",
            " 1 12 20 15 19",
            "",
            " 3 15  0  2 22",
            " 9 18 13 17  5",
            "19  8  7 25 23",
            "20 11 10 24  4",
            "14 21 16 12  6",
            "",
            "14 21 17 24  4",
            "10 16 15  9 19",
            "18  8 23 26 20",
            "22 11 13  6  5",
            " 2  0 12  3  7",
        )
        assertSolutionWorks("11", 4512, "3", "24", input)
    }

    @Test
    fun testInput12_final_acceptance() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(49) // I take a small part of the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = solveBingo(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 74981, "5", "97")
    }

    private fun assertSolutionWorks(
        testNumber: String,
        expected: Int,
        expectedLastWinnerBoard: String,
        expectedLastNumberDrawn: String,
        measurements: Array<String>
    ) {
        val actual = solveBingo(measurements)
        val formattedInputs = measurements.joinToString("\n")
        Assert.assertEquals(
            "Test #$testNumber : Expected score $expected, but was $actual. Expected winner board : $expectedLastWinnerBoard with last number drawn: $expectedLastNumberDrawn. Inputs provided were : \n$formattedInputs",
            expected,
            actual
        )
    }

    private fun assertSolutionWorksWithPuzzleInputSource(
        actual: Int,
        expected: Int,
        expectedLastWinnerBoard: String,
        expectedLastNumberDrawn: String,
    ) {
        Assert.assertEquals(
            "Wrong answer with data from a small portion of the puzzle input file content. Expected score $expected, but was $actual. Expected winner board : $expectedLastWinnerBoard with last number drawn: $expectedLastNumberDrawn.",
            expected,
            actual
        )
    }
}