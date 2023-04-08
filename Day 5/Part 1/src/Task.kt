fun overlaps(ventsLines: Array<String>): Int {
    val lines = Lines()
    return if (ventsLines.size >= 2) {
        repeat(ventsLines.size){
            lines.mergeWith(Line.fromLineOfVent(LineOfVent.fromString(ventsLines[it])))
        }
        return lines.overlaps()
    } else 0
}
data class Lines(private val data:MutableMap<Int,Line> = mutableMapOf()
){
     fun mergeWith(line: Line){
            data.merge(line.y,line,Line::mergeWith)
    }

    fun overlaps(): Int {
        println(data)
        return data.values.sumOf { it.overlaps() }
    }
}
data class Line(val y: Int, private val xValues: Map<Int, Int> = mutableMapOf()) {
    fun mergeWith(other:Line): Line {

val mergedXValues = xValues.toMutableMap()
        other.xValues.forEach{
            if(mergedXValues.containsKey(it.key)){
                mergedXValues[it.key]=it.value+mergedXValues[it.key]!!
            }else{
                mergedXValues[it.key]=it.value
            }
        }
        return Line(y, mergedXValues)
    }

    fun overlaps(): Int {
        return xValues.values.count { it > 1 }
    }

    companion object{
    fun fromLineOfVent(lineOfVent: LineOfVent):Line{
        val xValues = mutableMapOf<Int, Int>()
        (lineOfVent.x1 .. lineOfVent.x2).forEach{xValues[it]=1}
        println("fromlineofvent: "+xValues)
        return Line(lineOfVent.y1, xValues.toMap())
    }
}
}

class LineOfVent(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int
) {

    fun numberOfOverlapsWith(other: LineOfVent): Int {
        return if (!onTheSameYCoordinate(other))
            0
        else
            arrayOf(this.x2, other.x2)
                .minOrNull()!! - arrayOf(
                this.x1,
                other.x1
            ).maxOrNull()!! + 1
    }

    private fun onTheSameYCoordinate(other: LineOfVent) = this.y1 == other.y1

    companion object {
        fun fromString(string: String): LineOfVent {
            val (left, right) = string.split(" -> ")
            val (x1, y1) = left.split(",").map(String::toInt)
            val (x2, y2) = right.split(",").map(String::toInt)
            return LineOfVent(x1, y1, x2, y2)
        }
    }


}
