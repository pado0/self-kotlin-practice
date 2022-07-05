package inflearn

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.io.path.Path

fun main() {
 parseIntOrThrow("123")
 parseIntOrThrow("a")
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()

    } catch (e: java.lang.NumberFormatException) {
        throw java.lang.IllegalArgumentException("주어진 $str 은 숫자가 아닙니다")
    }
}

class FilePrinter{
    fun readFile(){
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }
}

// kotlin에서는 try with resources 구문이 없다
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use{reader -> // buffered reader에 대한 확장함수 사용
        println(reader.readLine())
    }
}