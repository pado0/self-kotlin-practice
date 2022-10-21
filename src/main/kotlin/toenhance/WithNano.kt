package toenhance

import java.time.LocalDate
import java.time.LocalTime

class WithNano {
}

fun main() {
    println(LocalTime.MAX.withNano(0))
}