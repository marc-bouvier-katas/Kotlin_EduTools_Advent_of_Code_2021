import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestDay4Part2 {

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
    fun testInput02_1_board() {
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
    fun testInput03_1_board() {
        val input = arrayOf(
            "1,3", // random numbers
            "",
            " 1  3", // __ __    Last drawn number : 3
            " 4  5"  //  4  5       4 + 5 = 9
            //                      9 * 3 = 27
        )
        assertSolutionWorks("03", 27, "1", "3", input)
    }

    @Test
    fun testInput04_1_board() {
        val input = arrayOf(
            "1,4",
            "",
            " 1  3", // __  3    Last drawn number : 4
            " 4  5"  // __  5       3 + 5 = 8
            //                      8 * 4 = 32
        )
        assertSolutionWorks("04", 32, "1", "4", input)
    }


    @Test
    fun testInput05_1_board_2_digit_numbers() {
        val input = arrayOf(
            "7,10,9",
            "",
            " 7 10", // __ __    Last drawn number : 10
            "11 12", // 11 12       11 + 12 = 23
            //                      23 * 10 = 230
        )
        assertSolutionWorks("05", 230, "1", "10", input)
    }

    @Test
    fun testInput06_1_board_3x3() {
        val input = arrayOf(
            "1,9,5,8,2,3", // random numbers
            "",
            " 1  3  2", // __ __ __    Last drawn number : 3
            " 4  5  8", //  4 __ __       4 + 10 + 20 = 34
            " 9 10 20"  // __ 10 20       34 * 3 = 102
        )
        assertSolutionWorks("06", 102, "1", "3", input)
    }

    @Test
    fun testInput06_2_boards_one_winner() {
        val input = arrayOf(
            "1,8,14", // random numbers
            "",
            " 1  3  2",   // } First
            " 4  5  8",   // } board
            " 9 10 20", // }
            "",
            " 1  4  6", //   } Second
            " 8 10 12", // } board
            "14 16 18",// }
        )
//            _  4  6
//            _  10 12
//            __ 16 18
        // 66 * 14 = 924
        assertSolutionWorks("06", 924, "2", "14", input)
    }

    @Test
    fun testInput07_3_boards_one_winner() {
        val input = arrayOf(
            "1,3,9,8,4,2", // random numbers
            "",
            " 1  3 99", // } First
            " 4  5  8", // } board
            " 7 10 20",  // }
            "",
            " 1  4  6", //   } Second
            " 8 10 12", // } board
            "14 16 18",// }
            "",
            " 1  2  3", // } Third
            " 4  5  6", // } board
            " 7  8  9",  // }
        )
//            _  _  _
//            _  5  6
//            7  _  _
        // 5+6+7 = 18
        // 18 * 2 = 36
        assertSolutionWorks("07", 36, "3", "2", input)
    }

    @Test
    fun testInput09_several_winners() {
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
        assertSolutionWorks("09", 1924, "2", "13", input)
    }

    @Test
    fun testInput10_several_winners() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(49) // I take a small part of the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = solveLastWinAtBingo(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 29355, expectedBoardNumber = 4, winningDrawnNumber = 95)
    }

    private fun assertSolutionWorks(
        testNumber: String,
        expected: Int,
        expectedLastWinnerBoard: String,
        expectedLastNumberDrawn: String,
        measurements: Array<String>
    ) {
        val actual = solveLastWinAtBingo(measurements)
        val formattedInputs = measurements.joinToString("\n")
        Assert.assertEquals(
            "Test #$testNumber : Expected score $expected, but was $actual. Expected last winner board : $expectedLastWinnerBoard with last number drawn: $expectedLastNumberDrawn. Inputs provided were : \n$formattedInputs",
            expected,
            actual
        )
    }

    private fun assertSolutionWorksWithPuzzleInputSource(
        actual: Int,
        expected: Int,
        expectedBoardNumber: Int,
        winningDrawnNumber: Int
    ) {
        Assert.assertEquals(
            "Wrong answer with data from a small portion of the puzzle input file content. The board $expectedBoardNumber should have won after the $winningDrawnNumber has been drawn.",
            expected,
            actual
        )
    }
}