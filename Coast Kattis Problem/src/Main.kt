fun main() {
    val dimLineParts = readLine()!!.split(" ")
    val dimLineInts = ArrayList<Int>()
    dimLineParts.forEach { dimLineInts.add(it.toInt()) }
    val height = dimLineInts[1]
    val width = dimLineInts[0]
    val map = ArrayList<String>()

    for (i in 0 until height) {
        map.add(readLine()!!)
    }

    var coastCount = 0

    for (y in 0 until height) {
        for (x in 0 until width) {
            val curCoordinateBool = map[y][x]
            if(curCoordinateBool == '0'){

            }
        }
    }
    print(coastCount)
}