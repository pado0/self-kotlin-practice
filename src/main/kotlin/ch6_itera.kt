fun main() {
    //validateScoreIsNotNegative(-19)
    println(getGrate(88))

    validateScoreIsNotNegative(-10)

    judgeNumber(-1)
    judgeNumber(10)

    judgeNumber2(0)
}

fun validateScoreIsNotNegative(score: Int) {
    if(score !in 0..100) println("범위를 벗어났습니다.")
    if(score < 0 || score > 100) println("범위를 벗어났습니다. 2")
}

fun getPassOrFail(score: Int) :String{
    if(score >=50) return "P"
    else return "F"
}

fun getPassOrFailExpression(score: Int) :String{
    return if(score >=50) "P"
    else "F"
}

fun getGrate(score : Int): String{
    if(score >=90) return "A"
    else if(score >=80) return "B"
    else return "C"
}

// switch case 대신 when을 사용한다
fun getGradeWithSwitch(score: Int): String {
    return when (score / 10) { // return 도 expression
        9 -> "A" // case 없이 바로 경우를 작성하고 ->로 결과 작성
        8 -> "B"
        7 -> "C"
        else -> "D" // 나머지는 else로 표시
    }
}

fun getGradeWithSwitch2(score: Int): String {
    return when (score) { // return 도 expression
        in 90..99 -> "A" // case 없이 바로 경우를 작성하고 ->로 결과 작성
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D" // 나머지는 else로 표시
    }
}

fun startWIthA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A") // is로 검증하면 스마트캐스트 가능
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when(number){
        1, 0, -1 -> println("어디서 많이 본 숫자입니다")
        else -> println("0, -1, 1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when{
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}