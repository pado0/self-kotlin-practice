package programmers

import kotlin.math.abs

fun main() {

    print(p12918("1111"))
    print(p12918 ("a111"))

    print(p82612(3, 20, 4))
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