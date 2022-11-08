package effectivekotlin

class item5 {
}

fun main() {

    pop(list = arrayListOf(1), num = 1)

}

fun pop(num: Any = 1L, list: List<Int>): List<Int>{

    require (num is Int && num > 2)

    require(list.isNotEmpty()){ // list가 비어있지 않아야한다.
        "조건이 만족하지 않을 경우 예외문구" // 비어있으면 이 문구와 함께 Illegal argument exception
    }

    check(num == 1){ // num이 1인지 확인하고, 1이 아니면 Illegal state exception과 함께 이 문구를 출력한다
        "조건이 만족하지 않을 경우 예외문구"
    }

    assert( num > 2)
    return list
}

fun smartcast(email: String?){
    require(email != null)
    val semail: String = email
}

fun nullability(text: String?) {
    val email:String = text ?: return
}