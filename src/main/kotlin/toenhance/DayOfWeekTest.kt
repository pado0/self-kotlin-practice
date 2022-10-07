package toenhance

import java.time.DayOfWeek
import java.time.LocalDate

class DayOfWeekTest {

}
fun main() {
    print(isMondayByTargetDate(LocalDate.of(2022, 10, 3)))
    print(LocalDate.of(2022,10,3).dayOfWeek)
}

fun isMondayByTargetDate(targetDate: LocalDate): Boolean{
    return targetDate.dayOfWeek == DayOfWeek.MONDAY
}

