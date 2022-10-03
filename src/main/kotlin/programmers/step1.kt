package programmers

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    println(p12934(50000000000000))
    println(p12934(3))
}

fun p12934(n: Long): Long {
    // 양의 정수임을 판단하여 해당 수의 제곱을 리턴한다.
    // 방법1. sqrt로 근접 제곱수를 구한다
    // 방법2. 반복문으로 근접시켜간다.

    return if (sqrt(n.toDouble()) == sqrt(n.toDouble()).toInt().toDouble()) {
        (sqrt(n.toDouble()).toLong() + 1).toDouble().pow(2).toLong()
    } else -1L
}