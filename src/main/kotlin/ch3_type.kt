fun main(){

    var d = 1.0 // double
    var f = 1.0f // float

    // 명시적 타입 변환 to기본타입()
    val number1 = 3
    // val number2: Long = number1 타입 변환되지 않아 컴파일단 오류
    val number2: Long = number1.toLong() // 명시적 타입변환 해야

    val number3 = 3
    val number4 = 5
    val result = number3 / number4.toDouble() // 명시적 변환 사용해야함
    println("d = $result")

    // null 처리
    val number5: Int? = 3
    val number6: Long = number5 ?.toLong() ?: 0L // Nullable의 경우 적절하게 null처리 필요

    val person = Person("hyojin")
    val log = "사람 이름은 ${person.name} 입니다"
    println("log = ${log}")

    println("""
        자유롭게 문자열을
        작성할 수 있습니다~~
    """.trimIndent())

    val str = "ABC"
    println(str[0])
}

fun printAgeIfPerson(obj: Any){ // Object는 kotlin에서 Any
    if(obj is Person ) {// instanceof 대신 is

        // as Person으로 obj를 Person으로 명시적 캐스팅
        // 스마트캐스트로 if 내에서 타입 체크를 해주었으므로 생략 가능
        val person = obj as Person
        println(person.name)
    }


}


