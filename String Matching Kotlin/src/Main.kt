import java.io.File

fun main(){
    val file = File("C:\\Users\\Gabriel Novack\\IdeaProjects\\String Matching Kotlin\\src\\sample")
    val arr = file.useLines { it.toList() }
    for(i in 0 until arr.size step 2){
        val foundPositions = ArrayList<Int>()
        val pattern = arr[i]
        var string = arr[i + 1]
    }
}