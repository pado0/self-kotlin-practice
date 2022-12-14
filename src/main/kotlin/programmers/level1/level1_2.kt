package programmers

import max
import java.lang.Integer.min
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

//    println(p68935(45))
//    println(p68935_r1(45))
//
//    println(p12926("ab z A ZrZ", 25))

//    println(p12915(arrayOf("sun", "bed", "car"), 1))
//    print(p132267(2,1,20))
//    print(p132267(3, 1, 20))

//    print(p133499(arrayOf()))

    print(isBabble("a"))
}

fun solution(a: Int, b: Int): String {
    var answer = ""

    println(a + b);

    return answer
}

fun p133499(babbling: Array<String>): Int {

    var answer = 0
    for(i in babbling){
        if(isBabble(i)) answer++
    }

    return answer
}


fun isBabble(input: String): Boolean {
    var str = input
    var flag = 0
    while (str.isNotEmpty()) {

        if (str.indexOf("aya") == 0) {
            if(flag == 1) return false
            str = str.substring(3 until str.length)
            flag = 1
        } else if (str.indexOf("ye") == 0) {
            if(flag == 2) return false
            str = str.substring(2 until str.length)
            flag = 2
        } else if (str.indexOf("woo") == 0) {
            if(flag == 3) return false
            str = str.substring(3 until str.length)
            flag = 3
        } else if (str.indexOf("ma") == 0) {
            if(flag == 4) return false
            str = str.substring(2 until str.length)
            flag = 4
        } else {
            return false
        }
    }

    return true
}

// sortedWith(compareBy()) 방식도 있다.
//return (if (n > b) n - b else 0) / (a - b) * b // 다음 코드 분석해보기
fun p132267(a: Int, b: Int, n: Int): Int {
    var count = n
    var answer = 0 // 현재 가진 병의 개수
    while (count > a - 1) {
        answer += count / a * b
        count = count / a * b + (count % a) // 빈병 a개를 n/a번 갖다주면 콜라병 b개가 생김
    }
    return answer

}

fun p12915(strings: Array<String>, n: Int): Array<String> {
    return strings.map { it[n] + it }.sorted().map { it.slice(1 until it.length) }.toTypedArray()
}

// 모든 명함을 담을 수 있는 가장 작은 카드지갑의 넓이 구하기
// 다이나믹 프로그래밍?
fun p86491(sizes: Array<IntArray>): Int {

    var a = 0
    var b = 0

    for (i in sizes) {
        a = max(max(i[0], i[1]), a) // 둘중 큰 것 중에 큰 것
        b = max(min(i[0], i[1]), b) // 둘중 작은 것 중에 큰 것
    }

    return a * b
}


// a를 25번 밀어야 z가 됨
// 26번 밀면 자기자신이 되니까 리셋 -> n은 1-25네
// 더한 결과가 z를 넘어가면 빼주면 되겠다.
fun p12926(s: String, n: Int): String {
    return s.map {
        if (it == ' ') it
        else if (it in 'a'..'z') {
            if (it + n in 'a'..'z') it + n
            else it + n - 26
        } else {
            if (it + n in 'A'..'Z') it + n
            else it + n - 26
        }
    }.joinToString("")
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
    while (x > 0) {
        y = (y * 10) + (x % 3)
        x /= 3
    }

    var i = 0
    while (y > 0) {
        answer += ((y % 10) * 3.0.pow(i.toDouble())).toInt()
        y /= 10
        i++
    }
    return answer
}


fun p12930(s: String): String {
    var answer = ""
    var p = 0
    for (i in s.indices) {
        if (s[i] == ' ') p = 1
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
    val mc = (1..max(n, m)).sortedDescending().first { n % it == 0 && m % it == 0 }.toInt()
    val mm = mc * (m / mc) * (n / mc)
    return intArrayOf(mc, mm)
}

fun p12969() {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    (1..b).forEach { (1..a).forEach { print("*") }; println() }
}

fun p82612_r1(price: Int, money: Int, count: Int): Long {
    return (1..count).map { it * price.toLong() }.sum().let {
        if (money > it) 0 else it - money
    }
}

fun p82612(price: Int, money: Int, count: Int): Long {
    var m = money.toLong()
    for (i in 1..count) m -= (price * i)
    return if (m < 0) abs(m) else 0L
}

fun p12950(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    for (j in 0 until arr1[0].size) { //arr1[0].size ==1
        for (i in 0 until arr1.size) { //arr1.size = 2
            arr1[i][j] += arr2[i][j]
        }
    }

    return arr1
}


fun p12918_r1(s: String): Boolean {
    return (s.length == 4 || s.length == 6) && s.toIntOrNull() != null
}

fun p12918(s: String): Boolean {
    // 길이가 6일때 알파벳이 두 개 섞여있으면 4가 될 수 있다.
    return if (s.length == 4) s.filter { it in '0'..'9' }.length == 4
    else if (s.length == 6) s.filter { it in '0'..'9' }.length == 6
    else false
}

fun p12917(s: String): String {
    return String(s.toCharArray().sortedArrayDescending())
}


// zip은 list pair로 만들어준다.
fun p70128_r1(a: IntArray, b: IntArray): Int {
    return a.zip(b).map { it.first * it.second }.sum()
}

fun p70128(a: IntArray, b: IntArray): Int {
    return (a.indices).sumOf { a[it] * b[it] }
}