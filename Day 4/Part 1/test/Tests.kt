import org.junit.Assert
import org.junit.Test

class TestDay4Part1 {

    @Test
    fun testInput01() {
        val input = arrayOf(
            "1,6,7,8,9", // random numbers
            "",
            "1 3", // } First
            "4 5"  // } board
        )
        assertSolutionWorks("01",0,input)
    }

    @Test
    fun testInput02() {
        val input = arrayOf(
            "1,2", // random numbers
            "",
            "1 2", // } First
            "3 4"  // } board
        )
        assertSolutionWorks("02",14,input)
    }

    @Test
    fun testInput03() {
        val input = arrayOf(
            "1,3", // random numbers
            "",
            "1 3", // } First
            "4 5"  // } board
        )
        assertSolutionWorks("03",27,input)
    }

    @Test
    fun testInput04() {
        val input = arrayOf(
            "1,4", // random numbers
            "",
            "1 3", // } First
            "4 5"  // } board
        )
        assertSolutionWorks("04",32,input)
    }



    @Test
    fun testInput05() {
        val input = arrayOf(
            "1,9,5,8,2,3", // random numbers
            "",
            "1 3 2", // } First
            "4 5 8", // } board
            "9 10 20"  // }
        )
//        __ __ __
//        4  __ __
//        __ 10 20
        // 34 * 3
        assertSolutionWorks("05",102,input)
    }

    @Test
    fun testInput06() {
        val input = arrayOf(
            "1,8,14", // random numbers
            "",
            "1 3 2",   // } First
            "4 5 8",   // } board
            "9 10 20", // }
            "",
            "1 4 6", //   } Second
            "8 10 12", // } board
            "14 16 18",// }
        )
//            _  4  6
//            _  10 12
//            __ 16 18
        // 66 * 14 = 924
        assertSolutionWorks("06",924,input)
    }

    @Test
    fun testInput07() {
        val input = arrayOf(
            "1,3,9,8,4,2", // random numbers
            "",
            "1 3 99", // } First
            "4 5 8", // } board
            "7 10 20",  // }
            "",
            "1 4 6", //   } Second
            "8 10 12", // } board
            "14 16 18",// }
            "",
            "1 2 3", // } Third
            "4 5 6", // } board
            "7 8 9",  // }
        )
//            _  _  _
//            _  5  6
//            7  _  _
        // 5+6+7 = 18
        // 18 * 2 = 36
        assertSolutionWorks("07",36,input)
    }

    @Test
    fun testInput08() {
        val input =  arrayOf("7,10,9",
            "",
            " 7 10  9",
            "11 12 13",
            "14 15 16",)
        assertSolutionWorks("08",729,input)
    }

    @Test
    fun testInput09() {
        val input =  arrayOf("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
            "",
            "22 13 17 11  0",
            "8  2 23  4 24",
            "21  9 14 16  7",
            "6 10  3 18  5",
            "1 12 20 15 19",
            "",
            "3 15  0  2 22",
            "9 18 13 17  5",
            "19  8  7 25 23",
            "20 11 10 24  4",
            "14 21 16 12  6",
            "",
            "14 21 17 24  4",
            "10 16 15  9 19",
            "18  8 23 26 20",
            "22 11 13  6  5",
            "2  0 12  3  7",)
        assertSolutionWorks("09",4512,input)
    }

    @Test
    fun testInput12() {
        val fullInputText = javaClass.getResource("full_input.txt").readText()
        val fullInput = fullInputText
            .split("\n")
            .map(String::trim)
            .take(49) // I take a small part of the file content in order to not spoil the Calendar result
            .toTypedArray()
        val actual = solveBingo(fullInput)
        assertSolutionWorksWithPuzzleInputSource(actual, 74981)
    }

    private fun assertSolutionWorks(testNumber: String, expected: Int, measurements: Array<String>) {
        val actual = solveBingo(measurements)
        val formattedMeasurements = measurements.joinToString("\n")
        Assert.assertEquals(
            "Test #$testNumber : Expected $expected, but was $actual. Measures provided were : \n$formattedMeasurements",
            expected,
            actual
        )
    }

    private fun assertSolutionWorksWithPuzzleInputSource(actual: Int, expected: Int) {
        Assert.assertEquals("Wrong answer with data from a small portion of the puzzle input file content", expected, actual)
    }
}