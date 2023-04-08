import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

// From this file you can write you own tests
// using JUnit 4 & assertJ assertions if you like
class YourOwnTests {

    @Test
    fun no_lines_means_no_overlaps() {
        val overlaps = overlaps(arrayOf())
        assertThat(overlaps).isEqualTo(0)
    }

    @Test
    fun two_lines_one_overlap() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 1,1",
                "0,1 -> 0,1"
            )
        )
        assertThat(overlaps).isEqualTo(1)
    }

    @Test
    fun two_lines_two_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 1,1",
                "0,1 -> 1,1",
            )
        )
        assertThat(overlaps).isEqualTo(2)
    }

    @Test
    fun two_lines_no_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 1,1",
                "0,2 -> 1,2",
            )
        )
        assertThat(overlaps).isEqualTo(0)
    }

    @Test
    fun two_lines_no_overlaps_2() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 0,1",
                "1,1 -> 1,1",
            )
        )
        assertThat(overlaps).isEqualTo(0)
    }

    @Test
    fun two_lines_2_overlaps_2() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 2,1",
                "1,1 -> 2,1",
            )
        )
        assertThat(overlaps).isEqualTo(2)
    }

    @Test
    fun two_lines_2_overlaps_3() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 3,1",
                "1,1 -> 2,1",
            )
        )
        assertThat(overlaps).isEqualTo(2)
    }

    @Test
    fun two_lines_2_overlaps_4() {
        val overlaps = overlaps(
            arrayOf(
                "1,1 -> 3,1",
                "1,1 -> 2,1",
            )
        )
        assertThat(overlaps).isEqualTo(2)
    }

    @Test
    fun two_lines_3_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "1,1 -> 3,1",
                "1,1 -> 3,1",
            )
        )
        assertThat(overlaps).isEqualTo(3)
    }


    @Test
    fun two_lines_3_overlaps_2() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 2,1",
                "0,1 -> 2,1",
            )
        )
        assertThat(overlaps).isEqualTo(3)
    }

    @Test
    fun two_lines_51_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 50,1",
                "0,1 -> 50,1",
            )
        )
        assertThat(overlaps).isEqualTo(51)
    }

    @Test
    fun two_lines_3_overlaps_3() {
        val overlaps = overlaps(
            arrayOf(
                "5,1 -> 9,1",
                "3,1 -> 7,1",
            )
        )
        assertThat(overlaps).isEqualTo(3)
    }

    @Test
    fun two_lines_3_overlaps_3_reversed() {
        val overlaps = overlaps(
            arrayOf(
                "3,1 -> 7,1",
                "5,1 -> 9,1",
            )
        )
        assertThat(overlaps).isEqualTo(3)
    }

    @Test
    fun three_lines_1_overlap() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 1,1",
                "1,1 -> 1,1",
                "1,2 -> 1,2",
            )
        )
        assertThat(overlaps).isEqualTo(1)
    }

    @Test
    fun three_lines_2_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 1,1",
                "0,1 -> 1,1",
                "1,1 -> 2,1"
            )
        )
        assertThat(overlaps).isEqualTo(2)
    }

    @Test
    fun three_lines_4_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 2,1",
                "1,1 -> 4,1",
                "2,1 -> 5,1",
            )
        )
        assertThat(overlaps).isEqualTo(4)
    }

    @Test
    fun four_lines_4_overlaps() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 2,1",
                "1,1 -> 4,1",
                "2,1 -> 5,1",
                "2,3 -> 5,3",
            )
        )
        assertThat(overlaps).isEqualTo(4)
    }


    @Test
    fun four_lines_1_overlap_from_vertical() {
        val overlaps = overlaps(
            arrayOf(
                "0,1 -> 0,2",
                "0,2 -> 0,2",
            )
        )
        assertThat(overlaps).isEqualTo(1)
    }
}