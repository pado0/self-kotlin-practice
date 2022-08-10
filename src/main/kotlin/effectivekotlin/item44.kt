package effectivekotlin

import java.util.StringJoiner

class item44 {
}
fun String.isPhoneNumber(): Boolean = length == 7 && all { it.isDigit()}

interface PhoneBook{
    fun String.isPhoneNumber(): Boolean
}

class Fizz: PhoneBook{
    override fun String.isPhoneNumber(): Boolean = length == 7 && all {it.isDigit() }
}

class A{
    val a= 10
}
class B{
    val a = 20
    val b = 30

    fun A.test() = a + b
}

fun main() {
    val b = B()
    val a = A()
}