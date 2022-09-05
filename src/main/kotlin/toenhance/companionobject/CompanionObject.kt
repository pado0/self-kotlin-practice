package toenhance.companionobject

import java.time.LocalDate
import java.time.LocalDateTime

class CompanionObject {

    companion object{
        val TEST = "MYTEST"
        fun testFun(){}
    }
}


val dayOfWeek = LocalDateTime.now().dayOfWeek.value // 현재 요일

val endDate: LocalDateTime =
    LocalDateTime.of(
        LocalDate.now().year,
        LocalDate.now().month,
        LocalDate.now().dayOfMonth,
        23, 59, 59, 999999999
    ).minusDays(
        dayOfWeek.toLong()
    )
val startDate: LocalDateTime =
    LocalDateTime.of(
        endDate.year,
        endDate.month,
        endDate.dayOfMonth.minus(6),
        0, 0, 0, 0
    )

fun main() {
    CompanionObject.testFun() // 동반 객체로 접근 가능. 마치 클래스 생성 없이 스태틱 함수에 접근할 수 있는 것 처럼
    println("dayOfWeek = ${dayOfWeek}")
    println("endDate = ${endDate}")
    println("startDate = ${startDate}")
}

