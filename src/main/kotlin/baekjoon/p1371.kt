import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>){

    // hash map으로 알파벳 카운트
    var result = HashMap<Char, Long>()

    // 원하는 만큼 입력 받기
    val input = Scanner(System.`in`)


    while (input.hasNext()) {
        val line = input.next()
        for (c in line) {
            result[c] = result[c]?.plus(1) ?: 1
        }
    }
}
