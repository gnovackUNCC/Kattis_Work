
fun main(){
    val num = readLine()!!.toInt()
    for(i in 0 until num){
        val line = readLine()!!
        val (left:String,right:String) = line.split(" ")
        val leftNum = left.toLong()
        val rightNum = right.toLong()
        val leftAdd = (leftNum * (leftNum + 1)) / 2 + 1
        val rightAdd = (rightNum * (2 * leftNum + rightNum + 3))/ 2
        val curNum = leftAdd + rightAdd
        println(curNum)
    }
}