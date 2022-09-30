package programmers

class p12928 {
}

fun main(){
    val n = 12
    var answer = 0
    for (i in 1..n) if( n % i == 0) answer+=i
    println("answer = ${answer}")

    val ans = (1..n).filter { n % it == 0 }.sum()
    println("ans = ${ans}")
}