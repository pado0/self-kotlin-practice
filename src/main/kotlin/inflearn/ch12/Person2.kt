package inflearn.ch12

fun main() {

}

class Person2 private constructor(
    var name: String,
    var age: Int
) {

    companion object Factory : Log{ // Log 인터페이스 상속
        const val MIN_AGE = 1
        fun newBaby(name: String): Person2 {
            return Person2(name, MIN_AGE)
        }

        override fun log() {
            println("person2의 동행객체 인터페이스 테스트")
        }
    }

}