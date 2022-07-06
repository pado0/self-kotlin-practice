import java.util.*

fun main(args: Array<String>) {

    while (true) {
        var result = 0;
        val input = readln()

        if(input == "#") return

        for (i in input.indices) {
            when (input[i]) {
                'a', 'e', 'i', 'o', 'u' -> result++
                'A', 'E', 'I', 'O', 'U' -> result++
            }
        }

        println(result)
    }
}