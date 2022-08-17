package weakness

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.TemporalAmount

class InstantPractice {
}
val dayOfWeek = LocalDateTime.now().dayOfWeek.value // 현재 요일

val endDate: LocalDateTime = // 종료 날짜
    LocalDateTime.of(
        LocalDate.now().year,
        LocalDate.now().month,
        LocalDate.now().dayOfMonth,
        23, 59, 59, 999999999
    ).minusDays(
        dayOfWeek.toLong()
    )
val startDate: LocalDateTime = // 시작 날짜
    LocalDateTime.of(
        endDate.year,
        endDate.month,
        endDate.dayOfMonth.minus(6),
        0, 0, 0, 0
    )

//master test commit2
//master test commit
// maseter check23
fun main() {

    val instant:Instant = endDate.toInstant(ZoneOffset.UTC)

    println()
    println("instant = ${instant}")
    //test commit
}