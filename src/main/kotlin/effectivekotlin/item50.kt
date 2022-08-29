package effectivekotlin

class item50 {
}

class Student(val name: String?)

fun main() {

    // 동작은 한다
    fun List<Student>.getNames1(): List<String> = this
        .map { it.name }
        .filter{ it != null}
        .map{ it!!}

    // 한 단계 줄이기
    fun List<Student>.getNames2(): List<String> = this
        .map { it.name }
        .filterNotNull()

    // 가장 좋은 방법
    fun List<Student>.getNames3(): List<String> = this
        .mapNotNull { it.name }
}