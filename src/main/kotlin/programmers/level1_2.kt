package programmers

import max
import kotlin.math.abs
import kotlin.math.pow

fun main() {

//    print(p12918("1111"))
//    print(p12918 ("a111"))
//
//    print(p82612(3, 20, 4))
//    p12969()
//
//    println(p12930("hello nice to meet u"))
//    println(p12930("try hello world"))

    println(p68935(45))
    println(p68935_r1(45))

}

// 지리는 진법 전환
fun p68935_r1(n: Int): Int {
    return n.toString(3).reversed().toInt(3) // 3진법을 10진수 int로
}
fun p68935(n: Int): Int {
    // n을 3진법에서 앞뒤로 뒤집은  이를 다시 10진법으로 표현
    var x = n
    var y = 0L
    var answer = 0

    // 뒤집어진 삼진법
    while(x  > 0){
        y = (y * 10) + (x % 3)
        x /= 3
    }

    var i = 0
    while(y > 0){
        answer += ((y % 10) * 3.0.pow(i.toDouble())).toInt()
        y /= 10
        i++
    }
    return answer
}



fun p12930(s: String): String{
    var answer = ""
    var p = 0
    for (i in s.indices) {
        if(s[i] == ' ') p = 1
        if (p % 2 == 0) answer += s[i].toUpperCase()
        else answer += s[i].toLowerCase()
        p++
    }

    return answer
}

fun p12940_r1(n: Int, m: Int): IntArray {
    val gcd = gcd(n, m)
    return intArrayOf(gcd, n * m / gcd)
}
tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

// 두 수의 최대공약수와 최소공배수
fun p12940(n: Int, m: Int): IntArray {
    val mc = (1..max(n,m)).sortedDescending().first { n % it == 0 && m % it == 0 }.toInt()
    val mm = mc * (m / mc) * (n / mc)
    return intArrayOf(mc, mm)
}

fun p12969() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    (1..b).forEach{(1..a).forEach {print("*")} ; println() }
}

fun p82612_r1(price: Int, money: Int, count: Int): Long {
    return (1..count).map { it * price.toLong() }.sum().let {
        if (money > it ) 0 else it - money
    }
}
fun p82612(price: Int, money: Int, count: Int): Long{
    var m = money.toLong()
    for(i in 1..count) m -= (price * i)
    return if (m < 0) abs(m) else 0L
}

fun p12950(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    for( j in 0 until arr1[0].size){ //arr1[0].size ==1
        for(i in 0 until arr1.size){ //arr1.size = 2
            arr1[i][j] += arr2[i][j]
        }
    }

    return arr1
}


fun p12918_r1(s: String): Boolean{
    return (s.length == 4 || s.length == 6) && s.toIntOrNull() != null
}

fun p12918(s: String): Boolean{
    // 길이가 6일때 알파벳이 두 개 섞여있으면 4가 될 수 있다.
    return if(s.length == 4) s.filter { it in '0'..'9' }.length == 4
    else if(s.length == 6) s.filter { it in '0'..'9' }.length == 6
    else false
}

fun p12917(s: String): String{
    return String(s.toCharArray().sortedArrayDescending())
}


// zip은 list pair로 만들어준다.
fun p70128_r1(a: IntArray, b: IntArray): Int {
    return a.zip(b).map { it.first * it.second }.sum()
}

fun p70128(a: IntArray, b: IntArray): Int {
    return (a.indices).sumOf { a[it] * b[it] }
}