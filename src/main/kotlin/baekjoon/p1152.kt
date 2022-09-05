import java.util.*

fun main(args: Array<String>) {

    // readln() == readLind()!!
    val input = "val"

    var result = 1

    if(input[0] == ' ') result--
    if(input[input.length-1] == ' ') result--

    for (i in input.indices) if (input[i] == ' ') result++


    println(result)


}
