import java.util.*

fun main(){
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val leftRightArr = scan.next().toCharArray()
    val changeArr = ArrayList<Int>()
    val ansArr = IntArray(n)
    var count = 1
    var leftRight = false
    

    for(i in leftRightArr){
        leftRight = when(i){
            'L' -> false
            else -> true
        }

    }
}