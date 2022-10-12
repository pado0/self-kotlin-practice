package programmers

import java.util.*
import kotlin.math.max
import kotlin.math.min
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

//    print(p12925("-1234"))
//    print(p12925_r1("-1234"))

//    print(Arrays.toString(p12954(2, 5)))
//    print(p12943(626331))

//    print(p12912(-10000000, 1))

//    val arr: Array<String> = arrayOf("Jane", "Kim")
//    print(p12919(arr))

//    print(p12948("1238491283812"))
//    print(p12948_r1("1238491283812"))

//    val arr = intArrayOf(5, 9, 7, 10)
//    print(p12910(arr, 5))
    val arr = p12935(intArrayOf(1,2,3,4,5))
    for (i in arr) {
        print(i)
    }
}

fun p12935(arr: IntArray): IntArray{

    var minValue = 2147000000
    for (i in arr) {
        if(i < minValue) minValue = i
    }
    return if(arr.size == 1) intArrayOf(-1) else arr.filter { it != minValue }.toIntArray()

}

fun p12910(arr: IntArray, divisor: Int): IntArray {

    val result = arr.filter { it % divisor == 0 }.sorted().toIntArray()
    return if (result.contentEquals(intArrayOf())) intArrayOf(-1) else result
}

fun p12948_r1(phone_number: String): String {
    return "".padStart(phone_number.length - 4, '*').plus(phone_number.takeLast(4))
}

fun p12948(phone_number: String): String {
    var charArr = phone_number.toCharArray()
    for( i in 0..phone_number.length - 5) charArr[i] = '*'
    return String(charArr)
}


fun p12919(seoul: Array<String>): String{
    return "김서방은 ${seoul.indexOf("Kim")}에 있다"
}

fun p12912(a: Int, b: Int): Long{
    return (min(a,b).toLong()..max(a,b)).sum()
}


// tailrec을 사용한 풀이 (꼬리 재귀). 사실 꼬리재귀보단, 이런 문제를 재귀로 풀 생각을 하지 못했다는 것을 반성!
// https://codechacha.com/ko/kotlin-tailrect/
// 재귀문을 반복문으로 바꾸는 역할

fun p12943_r1(num: Int): Int = recur(num.toLong(), 0)

tailrec fun recur(n: Long, c: Int): Int =
    when {
        c > 500 -> -1
        n == 1L -> c // 값이 1이 됐을 때 c를 리턴.
        else -> recur(if (n % 2 == 0L) n / 2 else (3 * n + 1), c + 1)
    }


fun p12943(num: Int): Int{
    var n = num.toLong()
    var answer = 0

    if( n == 1L) return 0

    while(n != 1L){
        if(answer >= 500) return -1
        if(n % 2 == 0L) n /= 2
        else n = n * 3 + 1
        println(n)
        answer ++
    }
    return answer
}

fun p87389_r1(n: Int): Int{
    return (1..n).first{n % it == 1}
}

fun p87389(n: Int): Int{
    var answer = 0
    for(x in 1..n) if(n % x == 1) {answer = x; break}
    return answer
}

// 아래와 같이 작업하면 iterator는 어디까지, 얼마나 동작하는걸까?
// 가설: LongArray의 크기인 n만큼.
// 답: https://github.com/JetBrains/kotlin/blob/1.2.0/core/builtins/native/kotlin/Array.kt#L31
// 위와 같이 람다를 입력으로 받는다.
fun p12954_r1(x: Int, n: Int): LongArray = LongArray(n) { x.toLong() * (it + 1) }

// 사실 아래의 형태임. 람다가 괄호 안 파라미터라 밖으로 뺄 수 있음.
fun p12954_r2(x: Int, n: Int): LongArray = LongArray(n, { x.toLong() * (it + 1) })

fun p12954(x: Int, n:Int): LongArray{
    var answer = longArrayOf()

    for (i in 1..n) {
        answer = answer.plus(x.toLong() * i)
    }

    return answer
}

fun p12925_r1(s: String): Int{
    return s.toInt()
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