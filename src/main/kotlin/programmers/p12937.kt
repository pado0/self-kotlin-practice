package programmers

class p12937 {

    fun other(num: Int): String{
        return if(num % 2 == 0) "Even" else "Odd"
    }

    // 1과 and 연산 할 경우 나머지가 구해지나?
    // 어떤 수와 이진수 1 (0001)을 and로 연산할 경우
    // 끝자리가 0일때만 0이 반환되고, 다른 수는 1이 반환될 수 밖에.
    // 그러니 1과 and를 해서 0이 되면 짝수이다. (이진수 첫째 자리가 0이면 짝수)
    fun theOther(num: Int): String{
        return if(num.and(1) == 0) "Even" else "Odd"
    }

}

fun main() {
    val num = 10;
    var answer = if (num % 2 == 0) "Even"
    else "Odd"
}