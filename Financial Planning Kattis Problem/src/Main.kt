import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val retire = scan.nextInt()
    val pairArr = ArrayList<Pair<Int, Int>>()
    val effArr = DoubleArray(n)
    var bestDays: Int

    for (i in 1..n) {
        val n1 = scan.nextInt()
        val n2 = scan.nextInt()
        effArr[i - 1] = n1.toDouble() / n2
        pairArr.add(Pair(n1, n2))
    }
    fun countDays(arr: ArrayList<Pair<Int, Int>>): Int {
        var price = 0
        var profit = 0
        var count = 0
        for (i in arr) {
            price += i.second
            profit += i.first
        }
        var curMoney = -price
        while (curMoney < retire) {
            curMoney += profit
            count++
        }
        return count
    }

    val bestPairs = ArrayList<Pair<Int, Int>>()

    var curDays = Integer.MAX_VALUE
    do {
        bestDays = curDays
        val mostEfficientIndex = effArr.indexOf(effArr.max()!!)
        bestPairs.add(pairArr[mostEfficientIndex])
        effArr[mostEfficientIndex] = Double.MIN_VALUE
        curDays = countDays(bestPairs)
    } while (curDays <= bestDays && bestPairs.size <= pairArr.size)

    print(bestDays)
}