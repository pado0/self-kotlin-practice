package programmers

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
//    println(p12934(50000000000000))
//    println(p12934(3))

//    println(p12932(12345).toList())
//    println(p12932_r1(12345).toList())
//    println(p12932_r2(12345).toList())

//    println(p12947(18))

//    print(p12933(12345))
//    print(p12933_r1(12345))

    print(p12925("-1234"))
}

fun p12925(s: String): Int{
    return if(s[0] == '-') s.filter { it != '-'}.toInt() * (-1)
    else s.filter { it != '+'  }.toInt()
}

fun p12933_r1(n: Long): Long{
    //String() 생성자는 array를 받아 String으로 넘긴다.
    return String(n.toString().toCharArray().sortedArrayDescending()).toLong()
}
fun p12933(n: Long): Long{
    return n.toString().map { it.toInt() - 48 }.sortedDescending().joinToString(separator = "").toLong()
}

fun p12947(x: Int): Boolean{
    // 하샤드 수: 자릿수 합으로 원래 수가 나누어 떨어져야 한다.
    return x % x.toString().map { it.toInt() - 48 }.sum() == 0
}

fun p12934(n: Long): Long {
    // 양의 정수임을 판단하여 해당 수의 제곱을 리턴한다.
    // 방법1. sqrt로 근접 제곱수를 구한다
    // 방법2. 반복문으로 근접시켜간다.

    return if (sqrt(n.toDouble()) == sqrt(n.toDouble()).toInt().toDouble()) {
        (sqrt(n.toDouble()).toLong() + 1).toDouble().pow(2).toLong()
    } else -1L
}

fun p12932(n: Long): IntArray{
    var t = n
    var i = 0

    while(t > 0){
        t /= 10
        i++
    }

    val arr = IntArray(i)
    i = 0
    t = n

    while(t > 0){
        arr[i] = (t % 10).toInt()
        t /= 10
        i++
    }

    return arr
}

fun p12932_r1(n: Long): IntArray{

    var t = n
    var arr = intArrayOf()

    while(t > 0){
        arr += (t % 10).toInt() // arr은 더해서 길이를 늘릴 수 있었지
        t /= 10
    }

    return arr
}

fun p12932_r2(n: Long): IntArray{

    return n.toString().reversed().toCharArray().map { it.toInt() - 48 }.toIntArray()

}