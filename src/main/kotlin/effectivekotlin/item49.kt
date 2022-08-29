package effectivekotlin

class item49 {
}

fun main() {
    val seq = sequenceOf(1, 2, 3)
    val filtered = seq.filter { println("f $it"); it % 2 == 1 }
    println("check : $filtered")

    val asList = filtered.toList()
    println(asList)

    val list = listOf(1, 2, 3)
    val listFiltered = list.filter{ it % 2 == 1}
    println(listFiltered)

    println("0-------0")
    sequenceOf(1,2,3)
        .filter { print("f$it, "); it % 2 == 1 }
        .map { print("m$it, "); it * 2 }
        .forEach { print("e$it, ") }

    println("0-------1")
    listOf(1,2,3)
        .filter { print("f$it, "); it % 2 == 1 }
        .map { print("m$it, "); it * 2 }
        .forEach { print("e$it, ") }

    println("0-------3")
    // 최소연산
    (1..10).asSequence()
        .filter { print("a$it ") ; it % 2 == 1 }
        .map {  print("b$it ") ; it * 2 }
        .find{ print("c$it "); it > 5 } // 조건에 맞는 원소를 발견하면 연산을 중지한. 6이 5보다 크므로 중지

    println("0-------4f")
    // 무한 시퀀스 방법 1
    generateSequence(8) { it + 1 }
        .map { it * 2 }
        .take(10)
        .forEach { print("$it, ") }

    println("0-------5f")
    // 무한 시퀀스 방법 2
    val fibonacci = sequence{
        yield(1)
        var current = 1
        var prev = 1
        while (true) {
            yield(current)
            val temp = prev
            prev = current
            current += temp
        }
    }

    // 무한시퀀스 사용시 몇 개의 값을 활용할지 지정해야한다. 안그러면 무한반복
    println(fibonacci.take(10).toList())


}