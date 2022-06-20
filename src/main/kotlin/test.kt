fun main() {
    val person = Person("hyo")
    // startsWithAJava(person.name)
}

fun startsWithAJava(str: String): Boolean{
    return str.startsWith("A")
}



// 방법 1.
fun startsWithA1(str: String?): Boolean {
    // null이 아닌 경우 함수 반환값 리턴, null이면 exception 던져!
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null 입니다")
}

// 방법2. safe call은 null이면 null이 리턴됨. 그냥 그대로 리턴.
fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

// 방법3.
fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWithA4(str: String?) : Boolean{
    return str!!.startsWith("A") // 절대 널이 아님을 단언
}

