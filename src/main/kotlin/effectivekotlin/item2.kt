package effectivekotlin

import java.time.LocalDate

class item2 {
}

fun main() {

    // 22p. 스코프를 최소화
    val users = arrayListOf("hyo", "hang", "ddeung")
    for ((i, user) in users.withIndex()) println("$i +  $user")

    // 23p. 선언 후 바로 초기화
    val user = if(LocalDate.now() > LocalDate.now().minusDays(1)) "future" else "past"

    // 23p. 여러 프로퍼디 한꺼번에 설정
    println(degreeOf(10))

    // 24p. 캡처링. 에라토스테네스의 채
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()){
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }
    println(primes)

    val primes2: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }
        while (true) {
            val prime = numbers.first()
            // yield(element): element 를 sequence consumer 에게 리턴하며 다음 consumer 의 다음 element 에 대한 요청이 있을 때까지 sequence() 의 실행은 중단된다.
            // yield(prime) : prime을 시퀀스 컨슈머에게 리턴.
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime != 0 }
        }
    }
    println(primes2.take(10).toList())

    val primes3: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }
        var prime: Int
        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime != 0 }
        }
    }
    println(primes3.take(10).toList())
}

fun degreeOf(degree: Int) {
    val (description, color) = when{
        degree < 4 -> "cold" to "yellow"
        degree < 10 -> "mild" to "red"
        else -> "hot" to "black"
    }
}

