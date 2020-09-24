import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val scan = Scanner(System.`in`)
    val n = scan.nextInt();
    val targetValue:BigInteger = scan.nextBigInteger()
    val bidders = ArrayList<Bidder>()
    var totalSum:BigInteger = 0.toBigInteger()

    for (i in 0 until n){
        val curName = scan.next()
        val curBid:BigInteger = scan.nextBigInteger()
        val bidder = Bidder(curName, curBid)
        if(curBid == targetValue){
            print("1 \n $bidder")
            return
        }
        else if (curBid < targetValue){
            bidders += bidder
            totalSum += curBid
        }
    }
    bidders.sortByDescending { it.bid }

    if(totalSum < targetValue){
        print("0")
        return
    }
    else if(totalSum == targetValue){
        println("${bidders.size}")
        for(i in bidders)
            println(i)
        return
    }

    val (reqSum, winners) = checkNecessary(totalSum, targetValue, bidders)
    var remaining:BigInteger = targetValue - reqSum

    for(i in bidders){
        if(i.bid == remaining){
            winners += i
            remaining -= i.bid
            break
        }
        else if(i.bid < remaining){
            winners += i
            remaining -= i.bid
        }
    }

    if(remaining != 0.toBigInteger())
        print("0")
    else {
        println("${winners.size}")
        for(i in winners)
            println(i)
    }
}

fun checkNecessary (sum:BigInteger, targetNum:BigInteger, arr:ArrayList<Bidder>):Pair<BigInteger, ArrayList<Bidder>> {
    var reqSum:BigInteger = 0.toBigInteger()
    val winners = ArrayList<Bidder>()
    for(i in arr){
        if(sum - i.bid < targetNum) {
            reqSum += i.bid
            winners += i
        }
    }
    arr.removeAll(winners)
    return Pair(reqSum, winners)
}

class Bidder(val name:String, val bid:BigInteger){
    override fun toString(): String {
        return name
    }
}